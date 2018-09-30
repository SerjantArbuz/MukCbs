package sgtmelon.mukcbs.app.view;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import sgtmelon.mukcbs.R;
import sgtmelon.mukcbs.app.model.ItemBook;
import sgtmelon.mukcbs.app.viewModel.VmActBook;
import sgtmelon.mukcbs.databinding.ActBookBinding;
import sgtmelon.mukcbs.office.def.DefIntent;

public class ActBook extends AppCompatActivity {

    private static final String TAG = ActBook.class.getSimpleName();

    private ActBookBinding binding;
    private VmActBook vm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.act_book);

        vm = ViewModelProviders.of(this).get(VmActBook.class);

        Bundle bundle = getIntent().getExtras();
        vm.setItemBook(bundle != null
                ? (ItemBook) bundle.getParcelable(DefIntent.BOOK)
                : savedInstanceState != null
                ? (ItemBook) savedInstanceState.getParcelable(DefIntent.BOOK)
                : null);

        setupToolbar();
        bind();
    }

    private void setupToolbar() {
        Log.i(TAG, "setupToolbar");

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(vm.getItemBook().getVolume() == 0 ? R.string.book_volume_0 : R.string.book_volume_1);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    private void bind() {
        Log.i(TAG, "bind");

        binding.setItemBook(vm.getItemBook());
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);

        outState.putParcelable(DefIntent.BOOK, vm.getItemBook());
    }

}
