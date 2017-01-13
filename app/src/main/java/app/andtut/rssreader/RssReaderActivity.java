package app.andtut.rssreader;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import app.andtut.R;
import app.andtut.databinding.ActivityRssReaderBinding;

public class RssReaderActivity extends AppCompatActivity {

    private ActivityRssReaderBinding mBinding;

    private String finalUrl="http://rss.slashdot.org/slashdot/slashdot";
    private HandleXml obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_rss_reader);
        mBinding.setActivity(this);
    }

    public void fetch(){
        obj = new HandleXml(finalUrl);
        obj.fetchXML();
        while(obj.parsingComplete);
        mBinding.titleEditText.setText(obj.getTitle());
        mBinding.linkEditText.setText(obj.getLink());
        mBinding.descriptionEditText.setText(obj.getDescription());
    }
}
