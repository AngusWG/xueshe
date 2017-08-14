package cn.huas.xueshe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.huas.xueshe.R;
import cn.huas.xueshe.activity.activity.activityList;
import cn.huas.xueshe.config.configXML;
import cn.huas.xueshe.notUse.MyListView4;
import cn.huas.xueshe.util.L;
import me.zhouzhuo.zzbeelayout.ZzBeeLayout;
import me.zhouzhuo.zzbeelayout.widget.com.meg7.widget.SvgImageView;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    ListView listView;
    FloatingActionButton mFab_1;
    FloatingActionButton mFab_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initZzBee();

        mFab_1 = (FloatingActionButton) findViewById(R.id.mainFab_1);
        mFab_2 = (FloatingActionButton) findViewById(R.id.mainFab_2);
        checklogin();

        listView = (ListView) findViewById(R.id.main_ListView);
/*
listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));
setContentView(listView);
*/

        SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.vlist,
                new String[]{"title", "info", "img"},
                new int[]{R.id.title, R.id.info, R.id.img});
        listView.setAdapter(adapter);
    }

    private void checklogin() {
        if (loginOn()) floatBtnChange(true);
        else floatBtnChange(false);
    }

    private void floatBtnChange(boolean isLoginOn) {
        if (isLoginOn == true) {
            mFab_1.setTitle("个人信息");
            mFab_2.setTitle("退出登录");
            mFab_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(MainActivity.this, UserInfo.class);
                    intent.putExtra("userId", configXML.getUserId());
                    startActivity(intent);
                }
            });
            mFab_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    configXML.clean();
                    finish();
                }
            });
        } else {
            mFab_1.setTitle("登录");
            mFab_2.setTitle("注册");
            mFab_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });
            mFab_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    private boolean loginOn() {
        L.e("userID:" + configXML.getUserId() + "   takon:" + configXML.getUserId());
        if (configXML.getUserId() == "") return false;
        else return true;
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "G1");
        map.put("info", "google 1");
        map.put("img", R.drawable.one);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G2");
        map.put("info", "google 2");
        map.put("img", R.drawable.two);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G3");
        map.put("info", "google 3");
        map.put("img", R.drawable.three);
        list.add(map);

        return list;
    }


    public void initZzBee() {
        //首页蜂窝设计
        ZzBeeLayout zzBeeLayout = (ZzBeeLayout) findViewById(R.id.bee);
        zzBeeLayout.setImageRes(new int[]{
                R.drawable.one,
                R.drawable.icon_shops,
                R.drawable.icon_deal,
                R.drawable.icon_skill,
                R.drawable.icon_act,
                R.drawable.one,
                R.drawable.icon_main
        });
        zzBeeLayout.setOnImageClickListener(new ZzBeeLayout.OnImageClickListener() {
            public void onImageClick(SvgImageView iv, int position) {
                switch (position) {
                    case 0:
                        Toast.makeText(MainActivity.this, "暂无板块", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this, Test.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "周边商店", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "二手物品交易", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this, RegisterActivity.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "技能交换", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "校园论坛", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this, MyListView4.class);
                        startActivity(intent);
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, "线下活动", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this, activityList.class);
                        startActivity(intent);
                        break;
                    case 5:
                        Toast.makeText(MainActivity.this, "暂无板块", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(MainActivity.this, "湖南文理学院", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "正在开发" + position, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
