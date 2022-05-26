package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresentationAnnotations {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ext","metier");
        IMetier metier = ctx.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
