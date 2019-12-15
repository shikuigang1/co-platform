package com.co.back.util;

import com.alibaba.nls.client.AccessToken;
import com.alibaba.nls.client.protocol.NlsClient;
import com.alibaba.nls.client.protocol.OutputFormatEnum;
import com.alibaba.nls.client.protocol.SampleRateEnum;
import com.alibaba.nls.client.protocol.tts.SpeechSynthesizer;
import com.alibaba.nls.client.protocol.tts.SpeechSynthesizerListener;
import com.alibaba.nls.client.protocol.tts.SpeechSynthesizerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Date;

public class TTSUtil {
    private static final Logger logger = LoggerFactory.getLogger(TTSUtil.class);
    private static long startTime;
    private static final String appKey = "OIbEEp5HITpJTPXh";
    private static final String ak_id = "LTAIs8O9INBHUhOD";
    private static final String ak_secret = "G9MVYSwxS8czrflb4QkkL4CxIsAzjy";
    private static long expiretime = 0;

    static NlsClient client;
    public TTSUtil(String appKey, String accessKeyId, String accessKeySecret) {

        //TODO 重要提示 创建NlsClient实例,应用全局创建一个即可,生命周期可和整个应用保持一致,默认服务地址为阿里云线上服务地址
        //TODO 这里简单演示了获取token 的代码，该token会过期，实际使用时注意在accessToken.getExpireTime()过期前再次获取token
        AccessToken accessToken = new AccessToken(accessKeyId, accessKeySecret);
        try {
            accessToken.apply();
            System.out.println("get token: " + accessToken.getToken() + ", expire time: " + accessToken.getExpireTime());
            client = new NlsClient(accessToken.getToken());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public TTSUtil(String appKey, String accessKeyId, String accessKeySecret, String url) {

        //TODO 重要提示 创建NlsClient实例,应用全局创建一个即可,生命周期可和整个应用保持一致,默认服务地址为阿里云线上服务地址
        //TODO 这里简单演示了获取token 的代码，该token会过期，实际使用时注意在accessToken.getExpireTime()过期前再次获取token
        AccessToken accessToken = new AccessToken(accessKeyId, accessKeySecret);
        try {
            accessToken.apply();
            System.out.println("get token: " + accessToken.getToken() + ", expire time: " + accessToken.getExpireTime());
            if(url.isEmpty()) {
                client = new NlsClient(accessToken.getToken());
            }else {
                client = new NlsClient(url, accessToken.getToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static SpeechSynthesizerListener getSynthesizerListener(String fileName) {
        SpeechSynthesizerListener listener = null;
        try {
            listener = new SpeechSynthesizerListener() {
                File f=new File("/usr/local/wav/"+fileName+".wav");
                FileOutputStream fout = new FileOutputStream(f);
                private boolean firstRecvBinary = true;
                //语音合成结束
                @Override
                public void onComplete(SpeechSynthesizerResponse response) {
                    // TODO 当onComplete时表示所有TTS数据已经接收完成，因此这个是整个合成延迟，该延迟可能较大，未必满足实时场景
                    System.out.println("name: " + response.getName() +
                            ", status: " + response.getStatus()+
                            ", output file :"+f.getAbsolutePath()
                    );
                }
                //语音合成的语音二进制数据
                @Override
                public void onMessage(ByteBuffer message) {
                    try {
                        if(firstRecvBinary) {
                            // TODO 此处是计算首包语音流的延迟，收到第一包语音流时，即可以进行语音播放，以提升响应速度(特别是实时交互场景下)
                            firstRecvBinary = false;
                            long now = System.currentTimeMillis();
                            logger.info("tts first latency : " + (now - TTSUtil.startTime) + " ms");
                        }
                        byte[] bytesArray = new byte[message.remaining()];
                        message.get(bytesArray, 0, bytesArray.length);
                        fout.write(bytesArray);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onFail(SpeechSynthesizerResponse response){
                    // TODO 重要提示： task_id很重要，是调用方和服务端通信的唯一ID标识，当遇到问题时，需要提供此task_id以便排查
                    System.out.println(
                            "task_id: " + response.getTaskId() +
                                    //状态码 20000000 表示识别成功
                                    ", status: " + response.getStatus() +
                                    //错误信息
                                    ", status_text: " + response.getStatusText());
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listener;
    }
    public static  boolean process(String param,String mobile,String fileName) {
        SpeechSynthesizer synthesizer = null;
        try {
            long time = new Date().getTime();
            if(expiretime < time ){
                AccessToken accessToken = new AccessToken(ak_id, ak_secret);
                accessToken.apply();
                expiretime = accessToken.getExpireTime()*1000;
                if(client == null){
                    client = new NlsClient(accessToken.getToken());
                }else{
                    client.setToken(accessToken.getToken());
                }

            }
            //创建实例,建立连接
            synthesizer = new SpeechSynthesizer(client, getSynthesizerListener(fileName));
            synthesizer.setAppKey(appKey);
            //设置返回音频的编码格式
            synthesizer.setFormat(OutputFormatEnum.WAV);
            //设置返回音频的采样率
            synthesizer.setSampleRate(SampleRateEnum.SAMPLE_RATE_8K);
            //发音人
            synthesizer.setVoice("Siqi");
            //语调，范围是-500~500，可选，默认是0
            synthesizer.setPitchRate(0);
            //语速，范围是-500~500，默认是0
            synthesizer.setSpeechRate(0);
            //设置用于语音合成的文本
            synthesizer.setText(mobile+"用户您好，您有一份任务需要处理，工单id为“"+param+"”，请您及时安排工作，谢谢。");
            //此方法将以上参数设置序列化为json发送给服务端,并等待服务端确认
            long start = System.currentTimeMillis();
            synthesizer.start();
            logger.info("tts start latency " + (System.currentTimeMillis() - start) + " ms");
            TTSUtil.startTime = System.currentTimeMillis();
            //等待语音合成结束
            synthesizer.waitForComplete();
            logger.info("tts stop latency " + (System.currentTimeMillis() - start) + " ms");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            //关闭连接
            if (null != synthesizer) {
                synthesizer.close();
            }
        }
    }


    public static  boolean process(String content,String fileName) {
        SpeechSynthesizer synthesizer = null;
        try {
            long time = new Date().getTime();
            if(expiretime < time ){
                AccessToken accessToken = new AccessToken(ak_id, ak_secret);
                accessToken.apply();
                expiretime = accessToken.getExpireTime()*1000;
                if(client == null){
                    client = new NlsClient(accessToken.getToken());
                }else{
                    client.setToken(accessToken.getToken());
                }

            }
            //创建实例,建立连接
            synthesizer = new SpeechSynthesizer(client, getSynthesizerListener(fileName));
            synthesizer.setAppKey(appKey);
            //设置返回音频的编码格式
            synthesizer.setFormat(OutputFormatEnum.WAV);
            //设置返回音频的采样率
            synthesizer.setSampleRate(SampleRateEnum.SAMPLE_RATE_8K);
            //发音人
            synthesizer.setVoice("Siqi");
            //语调，范围是-500~500，可选，默认是0
            synthesizer.setPitchRate(0);
            //语速，范围是-500~500，默认是0
            synthesizer.setSpeechRate(0);
            //设置用于语音合成的文本
            synthesizer.setText(content);
            //此方法将以上参数设置序列化为json发送给服务端,并等待服务端确认
            long start = System.currentTimeMillis();
            synthesizer.start();
            logger.info("tts start latency " + (System.currentTimeMillis() - start) + " ms");
            TTSUtil.startTime = System.currentTimeMillis();
            //等待语音合成结束
            synthesizer.waitForComplete();
            logger.info("tts stop latency " + (System.currentTimeMillis() - start) + " ms");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            //关闭连接
            if (null != synthesizer) {
                synthesizer.close();
            }
        }
    }


    public void shutdown() {
        client.shutdown();
    }
    public static void main(String[] args) throws Exception {
        /*String appKey = "填写你的appkey";
        String id = "填写你在阿里云网站上的AccessKeyId";
        String secret = "填写你在阿里云网站上的AccessKeySecret";
        String url = ""; // 默认即可，默认值：wss://nls-gateway.cn-shanghai.aliyuncs.com/ws/v1
        if (args.length == 3) {
            appKey   = args[0];
            id       = args[1];
            secret   = args[2];
        } else if (args.length == 4) {
            appKey   = args[0];
            id       = args[1];
            secret   = args[2];
            url      = args[3];
        } else {
            System.err.println("run error, need params(url is optional): " + "<app-key> <AccessKeyId> <AccessKeySecret> [url]");
            System.exit(-1);
        }*/
        TTSUtil demo = new TTSUtil("OIbEEp5HITpJTPXh", "LTAIs8O9INBHUhOD", "G9MVYSwxS8czrflb4QkkL4CxIsAzjy");
        demo.process("1234","123456789","111");
        demo.shutdown();
    }
}
