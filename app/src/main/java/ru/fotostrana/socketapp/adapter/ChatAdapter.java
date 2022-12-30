package ru.fotostrana.socketapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.model.Message;


/* loaded from: classes2.dex */
public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    ArrayList<Message> list;

    public ChatAdapter(Context context, ArrayList<Message> arrayList) {
        this.context = context;
        this.list = arrayList;
    }

    private class SelfMessageViewHolder extends RecyclerView.ViewHolder {
        TextView messageTV;
        SelfMessageViewHolder(View view) {
            super(view);
            this.messageTV = (TextView) view.findViewById(R.id.message_body);
        }

        void bind(int i) {
            this.messageTV.setText(ChatAdapter.this.list.get(i).getMessage());
        }

        public void addItem(Message message) {
            ChatAdapter.this.list.add(message);
            ChatAdapter chatAdapter = ChatAdapter.this;
            chatAdapter.notifyItemInserted(chatAdapter.list.size());
        }
    }
    private class OtherMessageViewHolder extends RecyclerView.ViewHolder {
        TextView messageTV;
        OtherMessageViewHolder(View view) {
            super(view);
            this.messageTV = (TextView) view.findViewById(R.id.message_body);
        }
        void bind(int i) {
            this.messageTV.setText(ChatAdapter.this.list.get(i).getMessage());
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new SelfMessageViewHolder(LayoutInflater.from(this.context).inflate(R.layout.self_message, viewGroup, false));
        }
        return new OtherMessageViewHolder(LayoutInflater.from(this.context).inflate(R.layout.others_message, viewGroup, false));
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (this.list.get(i).getMessageType() == 1) {
            ((SelfMessageViewHolder) viewHolder).bind(i);
        } else {
            ((OtherMessageViewHolder) viewHolder).bind(i);
        }
    }
    @Override
    public int getItemCount() {
        return this.list.size();
    }

    @Override
    public int getItemViewType(int i) {
        return this.list.get(i).getMessageType();
    }
}
