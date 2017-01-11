package app.andtut.linkedinintegration;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.linkedin.platform.APIHelper;
import com.linkedin.platform.LISessionManager;
import com.linkedin.platform.errors.LIApiError;
import com.linkedin.platform.errors.LIAuthError;
import com.linkedin.platform.listeners.ApiListener;
import com.linkedin.platform.listeners.ApiResponse;
import com.linkedin.platform.listeners.AuthListener;
import com.linkedin.platform.utils.Scope;

import app.andtut.R;
import app.andtut.databinding.ActivityLinkedinIntegrationBinding;

public class LinkedinIntegrationActivity extends AppCompatActivity {

    private ActivityLinkedinIntegrationBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_linkedin_integration);
        mBinding.setActivity(this);
        LISessionManager.getInstance(getApplicationContext()).init(this, buildScope(), new AuthListener() {
            @Override
            public void onAuthSuccess() {
                // Authentication was successful.  You can now do
                // other calls with the SDK.
            }

            @Override
            public void onAuthError(LIAuthError error) {
                // Handle authentication errors
            }
        }, true);
    }

    // Build the list of member permissions our LinkedIn session requires
    private static Scope buildScope() {
        return Scope.build(Scope.R_BASICPROFILE, Scope.W_SHARE);
    }

    public void open(){
//        Intent shareIntent = new Intent();
//        shareIntent.setAction(Intent.ACTION_SEND);
//        shareIntent.setType("text/plain");
//        shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, from tutorialspoint");
//        startActivity(Intent.createChooser(shareIntent, "Share your thoughts"));

        String url = "https://api.linkedin.com/v1/people/~/shares";

        String payload = "{" +
            "\"comment\":\"Check out developer.linkedin.com! " +
            "http://linkd.in/1FC2PyG\"," +
            "\"visibility\":{" +
            "    \"code\":\"anyone\"}" +
            "}";

        APIHelper apiHelper = APIHelper.getInstance(getApplicationContext());
        apiHelper.postRequest(LinkedinIntegrationActivity.this, url, payload, new ApiListener() {
            @Override
            public void onApiSuccess(ApiResponse apiResponse) {
                Log.i("Test", apiResponse.toString());
            }

            @Override
            public void onApiError(LIApiError liApiError) {
                Log.i("Test", liApiError.toString());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Add this line to your existing onActivityResult() method
        LISessionManager.getInstance(getApplicationContext()).onActivityResult(this, requestCode, resultCode, data);
    }
}
