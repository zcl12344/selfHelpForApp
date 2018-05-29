package com.springboot.tongyuyan.selfhelp.controller.WxAndAlipay.alipay;

public class AlipayConfig {
    // 1.商户appid
    public static String APPID = "2018052160198047";

    // 2.私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDHhha/EEnVJEtB\n" +
            "g0G9mCNdD9kzo91myEX7GdA1kUZdyrLCjB4qi3nLNi1G6Nc/4z8auJdRHPlje3tO\n" +
            "WrRdi+5ASCT+uaWXtJ/i06bfSrDCKO9hJSiL/eXGgS8m2+6SzbXeQznJFAzP8gGM\n" +
            "fI6gKkPlbzlEa/ueoK/OQ0j0gOYTT+ZwEgYbhc4APNL5idYvM3wM+c/Ib+1/ymqq\n" +
            "XUlujleGAmk+lD7C8yhk76YGCMWLJ+Zj+LuFAj0X/iXWW1hy5Fz3QCz7RCP/u9X4\n" +
            "8N7PXxeUy//ldr6dJ7NQNtQBfn6TEJXGdIiLdin0LqEm4GHjSP3cuGrobihrYPr5\n" +
            "dTYQciS7AgMBAAECggEAdbnDgBbPSajxkoUs6/5xlz57rQGZ6ERxLjjL5l+CgmLQ\n" +
            "WQQt5HKJeYLM8lL+dp7SJCUYe266I52/YrsYQz4GZP1sfrPxZfLYiBDUHFpIszdO\n" +
            "DybKptc3lYmx1Z7dRNeF4NAPr3paGPQ1P7xat1xY1W5r/tgsDivHr895o3LOzkNC\n" +
            "+GotT7kTOHYcibYpWUAB1Jsdgne+riLUS3s5R/qCJy4meJQrU+agIOCeio/MYWK9\n" +
            "x4Th2afAPXhTggis7p2uDnjfJAYxoj6TcXsM9L76a8eLnqcqUWMOvWYkYdp5un3k\n" +
            "zobEMfFHGG1ivAd3M8lf/hs+bpRW5pSYaO3MiNHXYQKBgQDmDoCiHXHFfqDs2cnn\n" +
            "IFsm06itkaGxi5+jDuG04WQQxEsOr7YjUd9RRTNw1m/LNkupUmKKE05DZm1OUS2S\n" +
            "wyRMxHYP46Q0uZec7ayZCREN9JsMLxEGUF13PzQRGhMGjlgoYokXtb/TutKJWYcH\n" +
            "C3t7cSyVa2wEYfT9ygiS9MqvKwKBgQDeBiJWSFQw2niPUDZWWgXQUvo/icGTQZ8C\n" +
            "YVcEmukGpClHK0Y7UxaAYbAtCP/Aanzs1e75tFGr3uJxl4QKm8JxL0Sa1QdukpkL\n" +
            "6cIU562bZJUUzKSXz3+d00OdesFbSxBBuFguTYXsIRYpan5Y9g29sDk6oK4Ua4mx\n" +
            "vlrkRikYsQKBgQDN9//8pKX+rp9/ToGwd0yEl412UGNWpO34u9Mh8YV4aXXVoUVN\n" +
            "m/h3N6CVjrcqVeMppkPo4N36BBMqwg0uT54JSP92vFWAiwUNj9EudmqZdvz1zJHO\n" +
            "eFcl8yU3hoOwI/MTvRyGaMdk1ee25ru4d/RHEY1b/YAI8Ha6XY6Nm7J3XwKBgCTv\n" +
            "0lCWceM6xWnaR1/wVB1HYLinW1v7Q8/qj8aFWxUuxGtBqMp/1TOAjQXBBINnc+cW\n" +
            "5E4IkLnON8/8DAyTwzJ/UaOMo1Li8rFHr3E45en/PsoaDZvv+mQwXIRbgsWEZGz6\n" +
            "lTkGzqvtCTnUrLZyIPEY2zyEtNFS3rKCX66weW/RAoGAAQ8OOmnsPrE67TCGEaVL\n" +
            "3qsKrKLmIHAvLjIdWXoI29vi/tw3BRUm9TOm29HpUTBCvKxyeCloKlaZcXDfJt4g\n" +
            "QlvKBZtzenPyT2HbUlzHQCQxYzcp+GSMxvkK0QbAkGE/iHJQzyLUxkehbHrM9MY1\n" +
            "3zNFeTv7QnbfkDYTJWW9lYs=";

    // 3.支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgjupHabg9a4epPXFNutO9jayET0lA72OPThhccYImw7zanensbfrPrufGsNsE8qsh2+FjAs1Z0CXPQo6Itx8lZ9cY1dirf0Wzj9a/chHoqdF1GtrPf1OhamnZlTmPvx/p4kBBt0eH6jiSCtzlW+GDYrHLYlpNH6dhi1EEEhdWIAmeBGFz8ZInNrq5UPkOTIEA58NbiRw2n9TrYDTEIC7WsOSmreA6Z08LgZdt1wbDA9S4pbwb7iElIh/VBEmBCKMrjjj2+JDIc9niVx1THu5wcF+Fa/h0+EP7i2vgNdygOVbuO/iL27qvByi3IfpM0vMdRWyNbO85ShhPtfpG8IENwIDAQAB";

    // 4.服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.xxx.com/alipay/notify_url.do";

    // 5.页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://www.xxx.com/alipay/return_url.do";

    // 6.请求网关地址
    public static String URL = "https://openapi.alipay.com/gateway.do";

    // 7.编码
    public static String CHARSET = "UTF-8";

    // 8.返回格式
    public static String FORMAT = "json";

    // 9.加密类型
    public static String SIGNTYPE = "RSA2";

}
