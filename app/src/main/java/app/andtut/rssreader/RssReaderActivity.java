package app.andtut.rssreader;

import android.Manifest;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lalosoft.easypermission.EasyPermissionActivity;
import com.lalosoft.easypermission.RegisterPermission;

import app.andtut.R;
import app.andtut.databinding.ActivityRssReaderBinding;

@RegisterPermission(permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
public class RssReaderActivity extends EasyPermissionActivity {

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
