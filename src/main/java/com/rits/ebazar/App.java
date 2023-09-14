package com.rits.ebazar;

import com.rits.ebazar.bean.Item;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author rits
 * @created on 14/09/2023
 * @project ebazar
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Bootstrapping the Rule Engine ..." );
        //1) Bootstrapping a Rule Engine Session
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession =  kContainer.newKieSession();

        Item item = new Item("A", 500.0,234.0);
        System.out.println( "Item Category: " + item.getCategory());
        //2) Provide information to the Rule Engine Context
        kSession.insert(item);
        //3) Execute the rules that are matching
        int fired = kSession.fireAllRules();
        System.out.println( "Number of Rules executed = " + fired );
        System.out.println( "Item Category: " + item.getCategory());
    }
}
