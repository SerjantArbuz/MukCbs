package sgtmelon.mukcbs.app.adapter;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sgtmelon.mukcbs.R;
import sgtmelon.mukcbs.databinding.ItemBookBinding;
import sgtmelon.mukcbs.office.intf.IntfItem;
import sgtmelon.mukcbs.app.item.ItemBook;

public class AdapterBook extends RecyclerView.Adapter<AdapterBook.BookHolder> {

    private List<ItemBook> listBook;

    public AdapterBook() {
        listBook = new ArrayList<>();
    }

    private IntfItem.Click itemClick;

    public void setItemClick(IntfItem.Click itemClick) {
        this.itemClick = itemClick;
    }

    public void updateAdapter(List<ItemBook> listBook) {
        this.listBook.clear();
        this.listBook.addAll(listBook);
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBookBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_book, parent, false);
        return new BookHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
        holder.bindItem(listBook.get(position));
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    class BookHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final View bkClick;
        private ItemBookBinding binding;

        BookHolder(ItemBookBinding binding) {
            super(binding.getRoot());

            bkClick = itemView.findViewById(R.id.itemBook_ll_click);
            bkClick.setOnClickListener(this);

            this.binding = binding;
        }

        void bindItem(ItemBook itemBook) {
            binding.setItemBook(itemBook);
            binding.executePendingBindings();
        }

        @Override
        public void onClick(View view) {
            itemClick.onItemClick(view, getAdapterPosition());
        }

    }
}
