/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.cmgp.api;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import uy.com.cmgp.datos.DaoClienteApi;
import uy.com.cmgp.dominio.ClienteApi;
import static java.util.concurrent.TimeUnit.*;

/**
 *
 * @author cmgp
 */
public class test {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void beepForAnHour() {
        final Runnable beeper = new Runnable() {
            @Override
            public void run() {
//                List<ClienteApi> cs = AccesoApiEstacion.getResultApi();
//           cs.forEach(c->{
//               System.out.println(c);
//           });
                System.out.println("End round");
            }
        };
        final ScheduledFuture<?> beeperHandle
                = scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                beeperHandle.cancel(true);
            }
        }, 30, SECONDS);
    }

    public static void useThread(){
//        Thread t = new Thread() {
//        @Override
//        public void run() {
//            int c = 0;
//            while (c < 20) {
//                try {
//                    Thread.sleep(5000l);
//                        List<ClienteApi> csa = AccesoApiEstacion.getResultApi();
//                csa.forEach(ca->{
//               System.out.println(ca);
//           });
//                System.out.println("End round");
//                } catch (InterruptedException ie) {
//                }
//            }
//        }
//    };
//
//    t.start ();
    }
}
