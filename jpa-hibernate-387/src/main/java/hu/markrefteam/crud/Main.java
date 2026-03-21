package hu.markrefteam.crud;

import hu.markrefteam.crud.config.HibernateUtil;
import hu.markrefteam.crud.dao.PersonDaoHibernate;
import hu.markrefteam.crud.service.PersonService;
import hu.markrefteam.crud.ui.ConsoleApp;

public class Main {
    public static void main(String[] args) {
        PersonService PersonService = new PersonService(new PersonDaoHibernate());

        Runtime.getRuntime().addShutdownHook(new Thread(HibernateUtil::shutdown));

        new ConsoleApp(PersonService).run();
    }
}