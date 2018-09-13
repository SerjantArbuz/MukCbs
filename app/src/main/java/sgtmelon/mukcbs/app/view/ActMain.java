package sgtmelon.mukcbs.app.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sgtmelon.mukcbs.R;
import sgtmelon.mukcbs.app.adapter.AdpBook;
import sgtmelon.mukcbs.app.model.item.ItemBook;
import sgtmelon.mukcbs.app.viewModel.VmActMain;
import sgtmelon.mukcbs.databinding.ActMainBinding;
import sgtmelon.mukcbs.office.intf.IntfItem;
import sgtmelon.mukcbs.office.st.StSearch;

public class ActMain extends AppCompatActivity implements View.OnClickListener, IntfItem.Click,
        Callback<List<ItemBook>> {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    //region Variable
    private static final String TAG = "ActMain";

    private ActMainBinding binding;

    private VmActMain vm;
    //endregion

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");

        bind();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");

        binding = DataBindingUtil.setContentView(this, R.layout.act_main);

        vm = ViewModelProviders.of(this).get(VmActMain.class);
        vm.setServerCallback(this);

        setupToolbar();
        setupRecycler();

        if (savedInstanceState != null) {
            vm.setStSearch(new StSearch(savedInstanceState));
            updateAdapter();
        }
    }

    private void bind() {
        Log.i(TAG, "bind");

        binding.setStSearch(vm.getStSearch());
        binding.executePendingBindings();
    }

    private EditText searchEnter;

    private void setupToolbar() {
        Log.i(TAG, "setupToolbar");

        searchEnter = findViewById(R.id.editText_toolbarSearch_enter);

        ImageButton searchPlace = findViewById(R.id.iButton_toolbarSearch_place);
        ImageButton searchFind = findViewById(R.id.iButton_toolbarSearch_find);

        searchEnter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = searchEnter.getText().toString();

                StSearch stSearch = vm.getStSearch();
                stSearch.setText(text);
                vm.setStSearch(stSearch);

                bind();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        searchPlace.setOnClickListener(this);
        searchFind.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.i(TAG, "onClick");

        switch (view.getId()) {
            case R.id.iButton_toolbarSearch_place:
                final String[] checkName = getResources().getStringArray(R.array.search_place);
                final int[] checkItem = new int[]{vm.getStSearch().getPlace()};

                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle(getString(R.string.dlg_title_place))
                        .setSingleChoiceItems(checkName, checkItem[0], new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                checkItem[0] = i;
                            }
                        })
                        .setPositiveButton(getString(R.string.dlg_btn_accept), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                StSearch stSearch = vm.getStSearch();
                                stSearch.setPlace(checkItem[0]);
                                vm.setStSearch(stSearch);

                                bind();

                                dialog.cancel();
                            }
                        })
                        .setNegativeButton(getString(R.string.dlg_btn_cancel), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .setCancelable(true);

                AlertDialog dialog = alert.create();
                dialog.show();
                break;
            case R.id.iButton_toolbarSearch_find:
                StSearch stSearch = vm.getStSearch();
                stSearch.setTextLast();
                stSearch.setPlaceLast();
                vm.setStSearch(stSearch);

                bind();
                updateAdapter();
                break;
        }

    }

    private AdpBook adpBook;

    private void setupRecycler() {
        Log.i(TAG, "setupRecycler");

        RecyclerView recyclerView = findViewById(R.id.actMain_rv);

        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);

        adpBook = new AdpBook();
        recyclerView.setAdapter(adpBook);

        adpBook.setItemClick(this);
    }

    @Override
    public void onItemClick(View view, int p) {
        Log.i(TAG, "onItemClick");

        ItemBook itemBook = adpBook.getListBook().get(p);

        Intent intent = new Intent(this, ActBook.class);
        intent = itemBook.fillIntent(intent);

        startActivity(intent);
    }

    @Override
    public void onResponse(Call<List<ItemBook>> call, Response<List<ItemBook>> response) {
        if (response.body() != null) {
            StSearch stSearch = vm.getStSearch();
            stSearch.setLoad(false);
            vm.setStSearch(stSearch);

            bind();

            adpBook.setListBook(response.body());
            adpBook.notifyDataSetChanged();
        }
    }

    @Override
    public void onFailure(Call<List<ItemBook>> call, Throwable t) {
        Toast.makeText(ActMain.this, "An error occurred during networking", Toast.LENGTH_LONG).show();
    }

    private void updateAdapter() {
        Log.i(TAG, "updateAdapter");

        StSearch stSearch = vm.getStSearch();

        if (stSearch.isAccess()) {
            stSearch.setLoad(true);
            vm.setStSearch(stSearch);

            vm.loadData();
            bind();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");

        vm.getStSearch().fillBundle(outState);
    }

}
