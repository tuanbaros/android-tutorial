package app.andtut.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import app.andtut.R;
import app.andtut.databinding.ActivityClipBoardBinding;

public class ClipBoardActivity extends AppCompatActivity {

    private ActivityClipBoardBinding mBinding;

    private ClipboardManager myClipboard;
    private ClipData myClip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_clip_board);

        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);

        mBinding.copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = mBinding.copyEditText.getText().toString();
                myClip = ClipData.newPlainText("text", text);
                myClipboard.setPrimaryClip(myClip);
                Toast.makeText(getApplicationContext(), "Text Copied",
                    Toast.LENGTH_SHORT).show();
            }
        });

        mBinding.pasteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipData abc = myClipboard.getPrimaryClip();
                ClipData.Item item = abc.getItemAt(0);
                String text = item.getText().toString();
                mBinding.pasteEditText.setText(text);
                Toast.makeText(getApplicationContext(), "Text Pasted",
                    Toast.LENGTH_SHORT).show();
            }
        });

    }
}
