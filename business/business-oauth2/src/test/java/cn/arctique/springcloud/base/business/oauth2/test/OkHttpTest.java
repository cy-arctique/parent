package cn.arctique.springcloud.base.business.oauth2.test;

import cn.arctique.springcloud.base.common.util.JsonUtil;
import cn.arctique.springcloud.base.common.util.OkHttpUtil;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * @author arctique
 * @date 2020/9/17 15:06
 */
@Slf4j
public class OkHttpTest {

    @Test
    public void testGet() {
        String url = "http://www.baidu.com";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        String url = "http://localhost:8822/oauth/token";
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("username", "admin")
                .add("password", "123456")
                .add("grant_type", "password")
                .add("client_id", "client")
                .add("client_secret", "secret")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = client.newCall(request);

        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void okHttpUtilTest() {
        String url = "http://localhost:8822/oauth/token";
        Map<String, String> params = Maps.newHashMap();
        params.put("username", "admin");
        params.put("password", "123456");
        params.put("grant_type", "password");
        params.put("client_id", "client");
        params.put("client_secret", "secret");
        String post = OkHttpUtil.post(url, params);
        System.out.println(JsonUtil.toMap(post));
    }
}
