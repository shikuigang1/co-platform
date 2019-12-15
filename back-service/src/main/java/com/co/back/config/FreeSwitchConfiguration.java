package com.co.back.config;

import com.co.back.listener.ESLEventListener;
import org.freeswitch.esl.client.inbound.Client;
import org.freeswitch.esl.client.inbound.InboundConnectionFailure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther skg
 * @Date: 2019/12/6
 */
@Configuration
public class FreeSwitchConfiguration {

    private static final Logger log = LoggerFactory.getLogger(FreeSwitchConfiguration.class);

    @Value("${fs.host}")
    private String host ;

    @Value("${fs.port}")
    private Integer port;

    @Value("${fs.password}")
    private String password;


    @Bean(name = "fsInboundClient")
    public Client fsInboundClient() {
        final Client client = new Client();
        try
        {
            client.connect( host, port, password, 10 );
        }
        catch ( InboundConnectionFailure e )
        {
            log.error( "Connect failed", e );
            return null;
        }
        //注册事件处理程序
        ESLEventListener eslEventListener =  new ESLEventListener();
        /*eslEventListener.setFsInboundClient(client);
        eslEventListener.setCallPhoneRecordService(callPhoneRecordService);*/
        client.addEventListener(eslEventListener);
        client.setEventSubscriptions("plain", "all");

        return client;
    }
}
