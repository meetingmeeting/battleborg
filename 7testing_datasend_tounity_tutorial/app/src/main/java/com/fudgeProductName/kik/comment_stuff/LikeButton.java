package com.fudgeProductName.kik.comment_stuff;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.fudgeProductName.kik.utils.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by albert on 9/7/14.
 */
public class LikeButton extends AsyncTask<String, Integer, String> {


    final static String STREAMURL = "http://mobile.tanggoal.com/comment/like_comment/";
    JSONArray jsonArray;

    Activity activity;
    String userID, newNumLikes;
    JSONObject jsonOb;



    public LikeButton(String userID, Activity activity) {
        // this.rootView = rootView;
        this.activity = activity;
        this.userID = userID;

    }


    //interface to get result
    @Override
    protected String doInBackground(String... params) {
        try {


            jsonOb = JsonReader.readJsonFromUrl(STREAMURL + params[0]);
            Log.e("newlikesjson", "" + jsonOb);

             return jsonOb.getString("likes");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.d("here", "noJSON");
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);


        Log.e("newlikes", "" + result);

        newNumLikes = result;

        getNewNumLikes(newNumLikes);

    }// end post ex



    public String getNewNumLikes(String newNumLikes){

        return newNumLikes;
    }


}
