package com.example.todolist

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoAdapter(
    private val todos: MutableList<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    fun addTodoItem(todo: Todo) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = todos[position]
        val button = holder.itemView.findViewById<Button>(R.id.btnDelete)
        holder.itemView.apply {tvTodoTitle.text = curTodo.title}
        button.setOnClickListener{deleteItem(position)}
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    private fun deleteItem(index: Int){
//        var builder = AlertDialog.Builder(context)
//        builder.setTitle(R.string.delete_confirm)
//        builder.setMessage(R.string.delete_message)
//        builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id ->
            todos.removeAt(index)
            notifyDataSetChanged()
//        })
//        builder.show()
    }
}