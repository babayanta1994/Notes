package ru.trueip.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {


    List<Note> notes;
    NodeClickListener nodeClickListener;

    public void setNodeClickListener(NodeClickListener nodeClickListener) {
        this.nodeClickListener = nodeClickListener;
    }

    public NotesAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }

    interface NodeClickListener{
        public void onNodeClick(int position);
    }


    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note,parent,false);
        return new NotesViewHolder(view);

    }

    private String stringDayOfWeak(String value){
        String returnedVal="";
        switch (value){
            case "0":
                returnedVal = "Понедельник";
                break;
            case "1":
                returnedVal = "Вторник";
                break;
            case "2":
                returnedVal = "Среда";
                break;
            case "3":
                returnedVal = "Четверг";
                break;
            case "4":
                returnedVal = "Пятница";
                break;
            case "5":
                returnedVal = "Суббота";
                break;
            default:
                returnedVal = "Воскресенье";
                break;
        }

        return returnedVal;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.title.setText(note.getTitle());
        holder.description.setText(note.getDescription());
        holder.dayOfWeak.setText(stringDayOfWeak(note.getDayOfWeak()));
        int colorId;
        switch (note.getPriority()){
            case "1":
                colorId = holder.itemView.getResources().getColor(android.R.color.holo_red_light);
                break;
            case "2":
                colorId = holder.itemView.getResources().getColor(android.R.color.holo_orange_light);
                break;
            default:
                colorId = holder.itemView.getResources().getColor(android.R.color.holo_green_light);
                break;
        }
        holder.title.setBackgroundColor(colorId);

    }

    @Override
    public int getItemCount() {
       return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView description;
        private TextView dayOfWeak;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            dayOfWeak = itemView.findViewById(R.id.day_of_weak);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(nodeClickListener!=null){
                        nodeClickListener.onNodeClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }


}
