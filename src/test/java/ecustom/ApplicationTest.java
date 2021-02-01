package ecustom;



import com.google.gson.reflect.TypeToken;
import com.maxvision.core.client.utils.FileUtils;
import com.maxvision.core.client.utils.SimpleJsonProcessor;
import com.maxvision.zfba.conf.SysConfig;

import com.maxvision.zfba.module.ent.SysMenu;
import com.maxvision.zfba.module.ent.SysUser;
import com.maxvision.zfba.module.vo.CurrentUser;
import com.maxvision.zfba.util.AesEncryptUtils;
import org.junit.Test;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ApplicationTest {

    @Test
    public void test(){
        StringBuilder sb = new StringBuilder();
        sb.append(SysConfig.config.getImagePath()).append("face");
        //根据配置和时间生成前缀目录
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("/yyyy/MM/dd", Locale.CHINA);
        String s = now.format(formatter);
        sb.append(s);
        String dir = FileUtils.combinePath(sb.toString());
        //随机文件名
        StringBuilder builder = new StringBuilder();
        builder.append(now.getYear()).append(now.getMonth().getValue())
                .append(now.getDayOfMonth()).append(now.getHour())
                .append(now.getMinute()).append(now.getSecond());
        String file = builder.toString() + ".jpg";
        String path = FileUtils.combinePath(dir, file);
        System.out.println("path = " + path);
    }

    @Test
    public void test1() throws Exception{
        String s = "D:/root/zfbn/images/iris/2020/12/24\\5fe4362bd32c2442a03b2609.jpg";
        String s1 = AesEncryptUtils.encryptReplace(s);
        System.out.println("s1 = " + s1);
        String s2 = AesEncryptUtils.decryptReplae(s1);
        System.out.println("s2 = " + s2);

    }

    @Test
    public void test3(){
        String json = "{\n" +
                "    \"code\": 0,\n" +
                "    \"response\": [\n" +
                "        {\n" +
                "            \"box\": [\n" +
                "                182.69664,\n" +
                "                57.83358,\n" +
                "                154.32881,\n" +
                "                213.99286,\n" +
                "                0.0,\n" +
                "                0.9886246\n" +
                "            ],\n" +
                "            \"landmark\": [\n" +
                "                0.0,\n" +
                "                0.0,\n" +
                "                0.0,\n" +
                "                0.0,\n" +
                "                0.0,\n" +
                "                0.0,\n" +
                "                0.0,\n" +
                "                0.0,\n" +
                "                0.0,\n" +
                "                0.0\n" +
                "            ],\n" +
                "            \"pose\": [\n" +
                "                0.0,\n" +
                "                0.0,\n" +
                "                0.0\n" +
                "            ],\n" +
                "            \"clsId\": -1\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        SimpleJsonProcessor processor = new SimpleJsonProcessor();

    }

    @Test
    public void test4(){
        CompletableFuture.supplyAsync(()-> 1)
                .thenApplyAsync(i ->i+1)
                .thenApplyAsync(t->t*2)
                .whenComplete((r,e)-> System.out.println(r));

        CompletableFuture.supplyAsync(()->"hello")
                .thenApplyAsync(String::toUpperCase)
                .thenCombine(CompletableFuture.completedFuture("java"),
                        (s1,s2)->s1+s2)
                .thenAccept(System.out::println);


    }

    @Test
    public void test5() throws Exception {
        String[] str = {"214","door-2412","41231","door-2414"};

        List<String> strings = Arrays.asList(str);
        //所有的门
        List<String> door = strings.stream().filter(e -> e.contains("door"))
                .map(e -> e.split("-")[1]).collect(Collectors.toList());
        door.forEach(System.out::println);
        //区域
        door.addAll(strings.stream().filter(e -> !e.contains("door")).collect(Collectors.toList()));



        Thread.sleep(5);

    }


    @Test
    public void test6() throws Exception{
        CurrentUser user = CurrentUser.builder().loginId("1").perms(Arrays.asList("1"))
                .user(new SysUser()).roles(Arrays.asList("123"))
                .build();
        System.out.println(user);
    }


}
