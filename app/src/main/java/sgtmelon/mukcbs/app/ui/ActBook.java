package sgtmelon.mukcbs.app.ui;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import sgtmelon.mukcbs.R;
import sgtmelon.mukcbs.databinding.ActBookBinding;
import sgtmelon.mukcbs.app.item.ItemBook;

public class ActBook extends AppCompatActivity {

    //TODO вынести логику в ViewModel

    final String TAG = "ActBook";

    private ActBookBinding binding;
    private ItemBook itemBook;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");

        binding = DataBindingUtil.setContentView(this, R.layout.act_book);
        itemBook = new ItemBook(getIntent());

        setupToolbar();
        bind();
    }

    private void setupToolbar() {
        Log.i(TAG, "setupToolbar");

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(itemBook.getVolume() == 0 ? R.string.book_volume_0 : R.string.book_volume_1);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    private void bind() {
        Log.i(TAG, "bind");

        binding.setItemBook(itemBook);
        binding.executePendingBindings();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(TAG, "onOptionsItemSelected");

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
