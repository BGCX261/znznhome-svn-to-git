运行任务测试
http://localhost:8080/timer/timer?jobCode=100&period=2&timerId=test01&method=start
http://localhost:8080/timer/timer?jobCode=100&time=2012-08-02 17:55&period=1&delay=1&timerId=test01&method=start&mode=time

停止任务测试
http://localhost:8080/timer/timer?jobCode=100&period=2&timerId=test01&method=cancel

说明：
	参数：
		jobCode 类似于sid，用于区分任务； yes
		period 计时器任务执行的时间间隔；no
		time 执行日期或开始重复执行的日期，默认当前时间 ；no
		delay 延迟执行时间（秒） 默认60秒；no 
		jobName 计时器任务句柄，用于停止该任务，默认Job+日期;  yes
		method 启动：start；停止：stop;  yes
		mode 6中，对应6中TimerAdapter计时方式，mode取值以及同其他参数配套如下：  yes
			mode=time 需要输入time参数；表示：指定时间执行指定任务（仅执行一次）
			mode=time_period 需要输入time，period参数；表示：从指定时间开始，按照固定延时来执行任务（多次，执行周期不一定相等）
			mode=delay 需要delay参数；表示：指定延时执行指定任务（执行一次）
			mode=delay_period 需要输入delay，period参数；表示：从指定延时开始，按照固定延时来执行任务（多次，执行周期不一定相等）
			mode=fixed_time_period 需要输入time，period参数；表示：从指定时间开始，按照固定频率来执行任务（多次，执行周期相等）
			mode=fixed_delay_period 需要输入delay，period参数；表示：从指定延时开始，按照固定频率来执行任务（多次，执行周期相等）
		save 与我们无关，不要填写该参数；程序启动，load未完成任务时，系统自动加载该参数，与用户无关。任务请求是否保存到数据库（或xml），no表示不保存; no
		
	
	接口：
		IGdsJob.java 是定义好的接口，所有任务，必须实现这个接口；
		GdsJobExample.java 一个任务实例，通过httpunit接口发送数据；
		JobDispatcher.java 根据jobCode，生成所需job；
		GdsTimerAdapter.java 组织计时器任务的运行和停止，提供钩子函数，用于处理gds的任务；
		GdsJobListener.java 如果想启动gds时自动运行某些计时器任务，把它配置到web.xml；
		
		quartz
		
		
	使用 xml版：
		1. timer_xml.jar拷过去（支持xml存储方式）
		2. 依赖的jar包加进来：httpunit.jar， js-1.6R5.jar， jtidy-4aug2000r7-dev.jar，dom4j-1.6.1.jar，
							commons-logging-1.1.1.jar
		3. web.xml配置：
			用于reload未完成任务
			<servlet>
				<servlet-name>SystemInitServlet</servlet-name>
				<servlet-class>com.mapabc.commons.timer.servlet.ReloadTimerRequestServlet</servlet-class>
				<load-on-startup>3</load-on-startup>
			</servlet>
			配置你自己的servlet mapping
			<servlet>
				<description>This is the description of my J2EE component</description>
				<display-name>This is the display name of my J2EE component</display-name>
				<servlet-name>TimerServlet</servlet-name>
				<servlet-class>com.mapabc.commons.timer.servlet.TimerServlet</servlet-class>
			</servlet>
		
			<servlet-mapping>
				<servlet-name>TimerServlet</servlet-name>
				<url-pattern>/timer</url-pattern>
			</servlet-mapping>
		
		4. jobs.xml和timer_request.xml考到classes下
		5. new自己的job，需要实现ITimerJob接口；
		6. 将自己的job配置在jobs.xml里面
		
		检验：
		启动一个任务： http://localhost:8080/yourapp/timer?jobCode=100&time=2012-08-02 17:55&period=1&delay=1&timerId=test01&method=start&mode=time_period
		停止一个任务： http://localhost:8080/yourapp/timer?jobCode=100&time=2012-08-02%2017:55&period=1&delay=1&timerId=test01&method=cancel&mode=time_period
		启动一个任务后，重启tomcat，未完成的任务会重复执行；
		
		使用 postgres版：
		timer_xml.jar拷过去（支持xml存储方式）
		依赖的jar包加进来：httpunit.jar， js-1.6R5.jar， jtidy-4aug2000r7-dev.jar，dom4j-1.6.1.jar，
							commons-logging-1.1.1.jar，gds-common-log-1.3-SNAPSHOT.jar，gds-db-conn-1.3-SNAPSHOT.jar，
							postgis.jar，postgresql.jar，proxool-0.9.1.jar，proxool-cglib.jar
		web.xml配置：
			用于reload未完成任务
			<servlet>
				<servlet-name>SystemInitServlet</servlet-name>
				<servlet-class>com.mapabc.commons.timer.servlet.ReloadTimerRequestServlet</servlet-class>
				<load-on-startup>3</load-on-startup>
			</servlet>
			配置servlet
			<servlet>
				<description>This is the description of my J2EE component</description>
				<display-name>This is the display name of my J2EE component</display-name>
				<servlet-name>TimerServlet</servlet-name>
				<servlet-class>com.mapabc.commons.timer.servlet.TimerServlet</servlet-class>
			</servlet>
		
			<servlet-mapping>
				<servlet-name>TimerServlet</servlet-name>
				<url-pattern>/timer</url-pattern>
			</servlet-mapping>
		new自己的job，需要实现ITimerJob接口；
		将自己的job配置在jobs.xml里面
		
		检验：
		启动一个任务： http://localhost:8080/yourapp/timer?jobCode=100&timerId=test01&method=start&mode=time_period
		停止一个任务： http://localhost:8080/yourapp/timer?jobCode=100&time=2012-08-02%2017:55&period=1&delay=1&timerId=test01&method=cancel&mode=time_period
http://localhost:8080/znznhome/timer?jobCode=100&jobName=test01&method=start&mode=time_period
http://localhost:8080/znznhome/timer?jobName=test01&method=stop

	/** @Fields DELAY: 计时器任务中的延时时间，默认60秒*/
	public static final Long DELAY = 60l;
	
	
	/** @Fields PERIOD: 计时器任务中的间隔时间，默认60秒*/
	public static final Long PERIOD = 60l;
		
		
		
		