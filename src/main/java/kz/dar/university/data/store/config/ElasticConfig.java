//package kz.dar.university.data.store.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
//
//@Configuration
//public class ElasticConfig extends ElasticsearchConfiguration {
//
//    @Override
//    public ClientConfiguration clientConfiguration() {
//        return ClientConfiguration.builder()
//                .connectedTo("10.251.0.25:9092,10.251.1.25:9092,10.251.2.25:9092".split(","))
//                .usingSsl()
//                .build();
//    }
//
//}