import com.co.back.config.RepxCache;
import com.co.back.entity.RepxResultVO;
import org.apache.ibatis.executor.Executor;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther skg
 * @Date: 2019/11/28
 */
public class TestRex {

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    private List<Future<RepxResultVO>> resultList = new ArrayList<>();

    private HashMap<String,String> map = new HashMap<>();

    static String content = "中国zabc干什么周一";

    //static String pattern_str = "^.*(什么事|你打.*就是呗|咋啦|哎|哦|啊|嗯|噢|干嘛|怎么|昂|有事|送.*宽带).*$|(^(?!.*干什么).*对.*$)|(^(?!.*不是).*是.*$)";
    //static String pattern_str = "^.*哎(周一)";
    static String pattern_str = "^.*(干什)|*.(周一)|(周武王)|(ABC).*$";

    public static void main(String[] args){


		/*String str = "fasfdhg2343fj hgtj32534 gr346! @6768";
		String pattern = "(\\D*)(\\d*)(j\\b)(.*)";
		//String pattern = "(\\d*)(.*@)(\\D*)(.*)";
		//String pattern = "(\\d*)(\\D*)(.*@)(.*)";
		Pattern pa = Pattern.compile(pattern);
		Matcher ma = pa.matcher(str);
		if(ma.find()) {
			System.out.println(ma.group(0));//0是整个字符串，
			System.out.println(ma.group(1));//1是按照第一个()里的内容查找
			System.out.println(ma.group(2));//在查找中，程序已经按照pattern里的括号的顺序进行过查找
			System.out.println(ma.group(3));//后者在前者找的基础上进行寻找，下标逐渐后移
			System.out.println(ma.group(4));
		}

*/
        TestRex.findMultiByRegex(pattern_str,content);
    }

    public void testRate(Integer latchSize){ //参数意图个数
        //countDownLatch用于控制多个线程的完结状态
        CountDownLatch latch = new CountDownLatch(latchSize);
        long start = System.currentTimeMillis();
        for(int i=0;i< latchSize;latchSize++){
            Future<RepxResultVO> repxFuture = executorService.submit(()->generate(latch,i,"aa","bb"));
            resultList.add(repxFuture);
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //选择出匹配 最长的字段
        String intentionid = null;
        int maxLength = 0;//最大匹配长度
        for (Future future:resultList){
            Map<String,Integer> map;
            try {
                map = (Map<String,Integer>)future.get();
                map.keySet();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        }

    }

    public RepxResultVO generate(CountDownLatch countDownLatch, Integer latchSize, String content, String regxID){

        Pattern p = RepxCache.get(regxID);
        Matcher m = p.matcher(content);

        return null;
    }


    public static String findMultiByRegex(String regex, String msg) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(msg);
        StringBuffer message = new StringBuffer();

        System.out.println(m.groupCount());

        boolean flag  = m.find();
        System.out.println(flag);

        for(int i=0;i<m.groupCount();i++){
            System.out.println(m.group(i));
        }
        /*while (m.find()) {
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
            System.out.println(m.group(4));
            //message.append(m.group(3));
        }*/
        return message.toString();
    }
}
