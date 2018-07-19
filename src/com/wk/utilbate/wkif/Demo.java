package com.wk.utilbate.wkif;
/**
 *
 * @author dwk
 * @version 2018年6月5日 下午10:28:38
 */
public class Demo {
    public static void main(String[] args) {
        String[] pks = new String[]{
                "weixin",
                "qq",
                "sina",
                "facebook"
        };
        
        
        WKIf wkif = WKIf.create(pks);
        
        WKIf wkif_instance = wkif.getOneInstance();
        wkif_instance.addIf("weixin",new WKIfHandler() {
            @Override
            public void handler() {
                System.out.println("调用微信的判断");
            }
        }).addIf("sina", new WKIfHandler() {
            @Override
            public void handler() {
                System.out.println("哈哈哈，你要发微博吗？");
            }
        });
        
        
        
        wkif_instance.execute("weixin");
        wkif_instance.execute("sina");
    }
}
