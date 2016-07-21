package tomer.edu.firedemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

import tomer.edu.firedemo.models.Todo;

/**
 * 1) create an inner class of the viewHolder
 */
public class TodosRecyclerAdapter extends FirebaseRecyclerAdapter<Todo , TodosRecyclerAdapter.TodosViewHolder>{

    public TodosRecyclerAdapter(DatabaseReference ref) {
        super(Todo.class, R.layout.todo_item, TodosViewHolder.class, ref);
    }

    @Override
    protected void populateViewHolder(TodosViewHolder viewHolder, Todo model, int position) {
        viewHolder.tvTitle.setText(model.getTitle());
        viewHolder.tvDescription.setText(model.getContent());
    }

    //TODO: make it static
    public static class TodosViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvDescription;

        public TodosViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView)itemView.findViewById(R.id.tvDetails);
        }
    }
}
