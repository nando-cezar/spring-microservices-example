package com.company.notification;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

//import com.company.amqp.producer.RabbitMQMessageProducer;
//import com.company.notification.config.NotificationConfig;

@SpringBootApplication(
    scanBasePackages = {
        "com.company.notification",
        "com.company.amqp"
    }
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    /*@Bean
    CommandLineRunner commandLineRunner(
        RabbitMQMessageProducer producer, 
        NotificationConfig notificationConfig
        ){
        return args -> {
            producer.publish(
                new Person("Ali", 18), 
                notificationConfig.getInternalExchange(), 
                notificationConfig.getInternalNotificationRoutingKey());
        };
    }

    record Person(String name, int age){}*/
}