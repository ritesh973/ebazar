package com.rits.ebazar.service;

import com.rits.ebazar.bean.Coupon;
import com.rits.ebazar.bean.Item;
import com.rits.ebazar.model.Order;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author rits
 * @created on 14/09/2023
 * @project ebazar
 */
@Service
@Configuration
public class RuleService {
    @Bean
    public KieContainer kieContainer() {

        KieServices kieServices = KieServices.Factory.get();

//        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
//        kieFileSystem.write(ResourceFactory.newClassPathResource(file));
//        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
//        kieBuilder.buildAll();
//        KieModule kieModule = kieBuilder.getKieModule();
//
//        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
       // KieContainer kieContainer = kieServices.newKieClasspathContainer();

        KieContainer kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("org.rits",
                "BusinessRule",
                "1.0-0"));


        Results results = kieContainer.verify();
        results.getMessages().stream()
                .forEach((message) -> {
                    System.out.println(">> Message ( "+message.getLevel()+" ): "+message.getText());
                });
        if (results.hasMessages(org.kie.api.builder.Message.Level.ERROR)) {
            System.out.println(results.getMessages());
            throw new RuntimeException("Drool Container Not loaded");
        }
        kieContainer.getKieBaseNames().stream().map((kieBase) -> {
            System.out.println(">> Loading KieBase: "+ kieBase );
            return kieBase;
        }).forEach((kieBase) -> {
            kieContainer.getKieSessionNamesInKieBase(kieBase).stream().forEach((kieSession) -> {
                System.out.println("\t >> Containing KieSession: "+ kieSession );
            });
        });

        KieScanner scanner = kieServices.newKieScanner(kieContainer);
        scanner.start(10_000);

        return kieContainer;
    }

    public Item applyCategory(Item item){
        KieContainer kieContainer = this.kieContainer();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(item);
        kieSession.fireAllRules();
        return item;
    }
    public Order classifyCustomer(Order order){
        KieContainer kieContainer = this.kieContainer();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(order);
        kieSession.insert(order.getCustomer());
        kieSession.fireAllRules();
        return order;
    }
    public Collection<Coupon> applyCoupons(Order order){
        KieContainer kieContainer = this.kieContainer();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(order);
        kieSession.insert(order.getCustomer());
        kieSession.fireAllRules();
        Collection<Coupon> coupons = getFactsFromKieSession(kieSession, Coupon.class);
        return coupons;
    }
    public Order applyDiscount(Order order){
        KieContainer kieContainer = this.kieContainer();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(order);
        kieSession.insert(order.getCustomer());
        kieSession.fireAllRules();
        return order;
    }
    protected <T> Collection<T> getFactsFromKieSession(KieSession ksession, Class<T> classType) {
        return (Collection<T>) ksession.getObjects(new ClassObjectFilter(classType));
    }

}
