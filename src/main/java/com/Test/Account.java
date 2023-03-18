package com.Test;

public class Account {
	// 员工姓名
	private String name;
	// 员工绩效时间
	private String time;
	// 员工绩效分数
	private int score;

 	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getScore() {
		return score;
	}

	// 缺失代码：请补全以下方法，要求绩效范围在：[0,100] 之间，包括0和100。
    // 当参数在规定范围外时，不做任何动作
	public void setScore(int score) {
		if(score>=0&&score<=100){
			this.score=score;
		}
		
	}

	public Account() { }

	/**
	 * Account类的构造方法
	 * @param name
	 * @param time
	 * @param score
	 */
	public Account(String name, String time, int score) {
		this.name = name;
		this.time = time;
		this.score = score;
	}

	// 请修改该方法，以保证打印对象时输出格式如下：
    // {name:"zs";time:"2022-09";score:90}

	@Override
	public String toString() {
		return "{name:\"" +name+"\";time:\""+time+"\";score:"+score+"}";
	}
}
