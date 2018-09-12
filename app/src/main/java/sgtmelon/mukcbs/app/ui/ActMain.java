package sgtmelon.mukcbs.app.ui;

import android.content.DialogInterface;
import android.content.Intent;

import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sgtmelon.mukcbs.R;
import sgtmelon.mukcbs.app.adapter.AdapterBook;
import sgtmelon.mukcbs.databinding.ActMainBinding;
import sgtmelon.mukcbs.app.data.DataServer;
import sgtmelon.mukcbs.office.def.DefSearch;
import sgtmelon.mukcbs.office.st.StSearch;
import sgtmelon.mukcbs.office.intf.IntfItem;
import sgtmelon.mukcbs.app.item.ItemBook;

public class ActMain extends AppCompatActivity implements View.OnClickListener, IntfItem.Click, Toolbar.OnMenuItemClickListener {

    //TODO двухсторонний датабиндинг
    //TODO вынести логику в ViewModel

    final String TAG = "ActMain";

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");

        bind();
    }

    private ActMainBinding binding;

    private StSearch stSearch;
    private DataServer dataServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");

        binding = DataBindingUtil.setContentView(this, R.layout.act_main);

        stSearch = new StSearch();
        dataServer = new DataServer();

        setupToolbar();
        setupRecyclerView();
    }

    private void bind() {
        Log.i(TAG, "bind");

        binding.setStSearch(stSearch);
        binding.executePendingBindings();
    }

    private EditText searchEnter;

    private void setupToolbar() {
        Log.i(TAG, "setupToolbar");

        final TextWatcher searchEnterWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                stSearch.setText(searchEnter.getText().toString());
                bind();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        searchEnter = findViewById(R.id.editText_toolbarSearch_enter);

        ImageButton searchPlace = findViewById(R.id.iButton_toolbarSearch_place);
        ImageButton searchFind = findViewById(R.id.iButton_toolbarSearch_find);

        searchEnter.addTextChangedListener(searchEnterWatcher);

        searchPlace.setOnClickListener(this);
        searchFind.setOnClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    @Override
    public void onClick(View view) {
        Log.i(TAG, "onClick");

        switch (view.getId()) {
            case R.id.iButton_toolbarSearch_place:
                final String[] checkName = getResources().getStringArray(R.array.search_place);
                final int[] checkItem = new int[]{stSearch.getPlace()};

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
                                stSearch.setPlace(checkItem[0]);
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
                stSearch.setTextLast();
                stSearch.setPlaceLast();

                bind();
                updateAdapter();
                break;
        }

    }

    private List<ItemBook> listBook;
    private AdapterBook adapterBook;

    private void setupRecyclerView() {
        Log.i(TAG, "setupRecyclerView");

        RecyclerView recyclerView = findViewById(R.id.actMain_rv);

        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);

        listBook = new ArrayList<>();

        adapterBook = new AdapterBook();
        recyclerView.setAdapter(adapterBook);

        adapterBook.setItemClick(this);
    }

    @Override
    public void onItemClick(View view, int p) {
        Log.i(TAG, "onItemClick");

        ItemBook itemBook = listBook.get(p);

        Intent intent = new Intent(this, ActBook.class);
        intent = itemBook.fillIntent(intent);

        startActivity(intent);
    }

    Callback<List<ItemBook>> serverCallback = new Callback<List<ItemBook>>() {
        @Override
        public void onResponse(Call<List<ItemBook>> call, Response<List<ItemBook>> response) {
            if (response.body() != null) {
                listBook = response.body();

                stSearch.setLoad(false);
                bind();

                adapterBook.updateAdapter(listBook);
                adapterBook.notifyDataSetChanged();
            }
        }

        @Override
        public void onFailure(Call<List<ItemBook>> call, Throwable t) {
            Toast.makeText(ActMain.this, "An error occurred during networking", Toast.LENGTH_LONG).show();
        }
    };

    private void updateAdapter() {
        Log.i(TAG, "updateAdapter");

        if (stSearch.isAccess()) {
            stSearch.setLoad(true);
            bind();

            dataServer.getApi()
                    .getData(DefSearch.place_code[stSearch.getPlace()], stSearch.getTextLast())
                    .enqueue(serverCallback);
        }
    }

}
