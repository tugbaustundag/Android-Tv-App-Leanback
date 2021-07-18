package com.smality.androidtvleanback;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.*;

public class BrowseFragment extends BrowseSupportFragment {
    private ArrayObjectAdapter mArrayObjectAdapter;
    private static final int GRID_ITEM_WIDTH= 300;
    private static final int GRID_ITEM_HEIGHT= 200;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpUI();
        loadRows();
    }

    private void setUpUI() {
        //sağ üst köşedeki logoyu eklediğim kod
        setBadgeDrawable(getActivity().getResources().getDrawable(R.drawable.smality));
        //Soldaki kategori menüsünün background rengini belirledim
        setBrandColor(Color.parseColor("#e0f2f1"));

    }
    private void loadRows() {
        //ListRowPresenter;filmler listeleme görüntüsünü verebilmem için gerekli sınıf
        mArrayObjectAdapter =new ArrayObjectAdapter(new ListRowPresenter());
        //Soldaki kategori bölümü olarak gözüken yerin adı HeaderItem'dır
        //Item'a GERİLİM kategori isimini ekledim
        HeaderItem gridPresenterheader = new HeaderItem(0,"GERİLİM");
        //Film başlık alanlarını oluşturmak ve görselleştirmek için oluşturduğum sınıfı çağırdım
        GridItemPresenter gridItemPresenter = new GridItemPresenter();

        ArrayObjectAdapter mRowAdapter=new ArrayObjectAdapter(gridItemPresenter);
        //ArrayObjectAdapter'da film isimlerini ekledim
        mRowAdapter.add("HANNIBAL LECTER");
        mRowAdapter.add("CARGO");
        mRowAdapter.add("BIRD BOX");
        mRowAdapter.add("THE PLATFORM");
        //Üsttekki gibi kategori ve film başlığının gösterilmesi için işlemler
        //tekrar ettirdim.
        HeaderItem gridPresenterheader2 = new HeaderItem(1,"KOMEDİ");

        ArrayObjectAdapter mRowAdapter2=new ArrayObjectAdapter(gridItemPresenter);
        mRowAdapter2.add("ŞEKERPARE");
        mRowAdapter2.add("KUNFU PANDA");
        mRowAdapter2.add("THE INTERN");
        mRowAdapter2.add("MASKE");

        HeaderItem gridPresenterheader3 = new HeaderItem(1,"BELGESEL");

        ArrayObjectAdapter mRowAdapter3=new ArrayObjectAdapter(gridItemPresenter);
        mRowAdapter3.add("MERCAN PEŞİNDE");
        mRowAdapter3.add("DOĞADAKİ İNSAN");
        mRowAdapter3.add("INTO THE WILD");
        mRowAdapter3.add("127 SAAT");

        HeaderItem gridPresenterheader4 = new HeaderItem(2,"BİLİM KURGU");

        ArrayObjectAdapter mRowAdapter4=new ArrayObjectAdapter(gridItemPresenter);
        mRowAdapter4.add("TERMINATOR");
        mRowAdapter4.add("MATRIX");
        mRowAdapter4.add("ÖRÜMCEK ADAM");
        mRowAdapter4.add("X-MEN");

        mArrayObjectAdapter.add(new ListRow(gridPresenterheader,mRowAdapter));
        mArrayObjectAdapter.add(new ListRow(gridPresenterheader2,mRowAdapter2));
        mArrayObjectAdapter.add(new ListRow(gridPresenterheader3,mRowAdapter3));
        mArrayObjectAdapter.add(new ListRow(gridPresenterheader4,mRowAdapter4));

        setAdapter(mArrayObjectAdapter);
    }
    //Presenter sınıfı; bizim tüm UI elementlerimizi ekleyebileceğimiz
    //ve düzenleceğimiz sınıftır
    private class GridItemPresenter extends Presenter {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent) {
            //Film başlıklarını gösterilmesi için TextView tanımladım.
            TextView view = new TextView(parent.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT));
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            //Film başlık alanları için TextView'i görselleştirdim.
            view.setBackgroundColor(Color.parseColor("#b2ebf2"));
            view.setTextColor(Color.BLACK);
            view.setGravity(Gravity.CENTER);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object item) {
            ((TextView) viewHolder.view).setText((String) item);
        }
        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {
        }
    }
}

