package com.yc.fresh.util;

public class AlipayConfig {
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016102300742047";
	 
	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCsS064rc79wZ+p8QvjYLlrs7FeOapGzVMkom0H0Xq/ctM+3uH20SrGKGBMDChz+mIjJwEWmLJsLWPMcNVKXiJS6oLOLYeOmoOzhOFGaac4+LCkp8n5HNRY/gLNYWv4q6cPmiTQZN3yrhDzPwu3ssz7WK9jGvIAEUxtoQ4DosLdTwDTRBF7vZLBpg3khdHx/LP8ywl73WSFRM8J0sD34myyZMtx5Y5KSEKUJHCoBFxcw+nSJU71/qAeGZGvw6v/RX6snLWXykmtjFtwh0mwaaNWQwuWi4Dlb3V9Qv3hHe0g0gIgkwdWKpZzHyekqZMj1oF+pKxItL+NpyQF9qBqvD8rAgMBAAECggEANKZysPbUKTFRFEKH6nz1TJdF3VBr22UFQk2sWdZG11hEe5LqpFz44EMYYkTY29AoyysxJvGUnIAmXiQg2a/4dzQYst6w7QAEvQgfO0AwDLXabQalLs4DigpdWtupff0eeSMWmuQn+u/8WAjtEL6/6xMHzZY/W4vtuhacTLohKDVqQegS2BYV9FfJyCAGfHzB0GsSWotYzdfxfqPzHB7CfWYBgUAONtjKaIl55HtiAIwZ73K8ubQRTorjrhBPw9ioFmq7K8NjXN1hwCroPSmbMlmNRn3f0NnEBdvaabYEi0H0Xr7Wq2GWWgp3oTfQ7eue36W/drkxXnnVgQeRqeqXWQKBgQDn++Eljv8ZE4W22QtXSSDn6tG996b9utVxVypTzarudjw9G0uRk3jYkie8wERsbi8/OaitKyA5NDlCJ/F1OQdS8lk4GxhH36e69Us8Gc8XVjhlpU1jW4SlR07tO5c1EJwWVrxuKU9BKyUxyc8Whk2QhQLNu5G/ODHLab+/lyqA1wKBgQC+IYJiEtmtLSbYR4wI6YX7lNhRhDdhn8T7AfTVAtJwDpGeXVSy4dmCWs2XxV+ZrMYal01fOiHlDwU2K5F1cjdsIEj3alUJWwsbnEuNqF+qO16Y50Uq4y86aiJVx/7stkCJFXvfuGpc1yvHaAvDKqzJaLth3McRDtF/R54DaQwlzQKBgQCMD3cPxhYefbrten1uZaiIXS3lE/CuoG7dz1Ku5i2da6VS/3fQnMkJeLSlMTAehyffdGByrOb3oqAvYQ5XR+c0HT3gsfsm6dHK/u49ixeNb3D9baAbrNWZNERi1uekEjMrCZMar7Y6EmKSfNWbM9sAtk3LCMQmPzdRKLesZQg0YQKBgQCt9cTw7ORjkctX2eajhN7E+EQQGZP+a4t0Si7z8rgONRZBOo2zefdkUKaJddpppe5ACC2PsoWuqdaP4L8fIVjaQpPgZFbXz4hTQ+bQ/rxA6j88UWY0vlbI8LDnoax6cqqLgq+rW3Vd6rWwpl8Uu+gKBBxmhvVQgylldmZ6IlQuBQKBgDdndlQSvKAdBRjxRPvQ87gm8hZuEeKiECTtmwy0SuJYEQ1ePqY6TwvG8e07GKsqkS+ZZyp5svJRG7DPBpwJ8vGcTKOhC68xKJbVu4pXzVaAt7nxGG+B2yCTAf51f34Iw75oNU4SXV6JNv6pIvGvnmUUaJXuoLz+JaFGw5JiX0wM";
		
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApjJBb3+SjCSvBV8mzxdCeDz267h3cBsh6LC9pE4iY0pBZUmPDbyDbELfHSAhi3trqJ0GCEbpeNaPKCtauvwq3IU+M5sFbLiuR5sxqY8sqZ+1lsYZWJo86HjIiRPNcaEKofacJW13bSAoPDyafDhT+S32jVYDe+JQ9YaiXPOzfZvU53XgjGLF5LWZ6cfr+HCA9nLhMh9+joIZolNvQJD9EJYyAYqzKvAsstlXezXFYyErQYpaP034Ve7pSuF803enD9ZWFPydnSbWx97e4J3+Tgrw5FlFBOk42YaY406n6ralWP8Ob4C6y6PqMRArxWqBE4dKi9ZvEUFRWkCY6hFTaQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//异步通知页面，就是接受支付宝支付结果返回信息的Controller，可以处理自己的支付后的逻辑
	public static String notify_url = "http://localhost:9999/order/apli/notify";
	 
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//同步跳转的页面，就是支付宝支付成功后页面跳转的url
	/*public static String return_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";*/
	public static String return_url = "http://localhost:9999/order/apli/return";
	// 签名方式，注意这里，如果步骤设置的是RSA则用RSA
	public static String sign_type = "RSA2";
	 
	// 字符编码格式
	public static String charset = "utf-8";
	 
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	 
	// 支付宝网关
	public static String log_path = "C:\\";

}
