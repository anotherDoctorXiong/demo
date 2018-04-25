package com.demo.service;


import com.demo.PageBean;
import com.demo.mapper.AdminerMapper;
import com.demo.mapper.LocalMapper;
import com.demo.model.Adminer;
import com.demo.model.Local;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class adminerservice {
    @Autowired
    private AdminerMapper adminerMapper;
    @Autowired
    private LocalMapper localMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    public Adminer login(Adminer adminer){
        return adminerMapper.login(adminer);
    }
    public boolean checkuser(Adminer adminer){
        if(adminerMapper.login(adminer)!=null){
            return true;
        }else
            return false;
    }

    public boolean adduser(Adminer adminer){
        if(adminer.getcId().equals("")){
            adminer.setAuthor(2);
        }else{
            if(adminer.getbName().equals("")){
                adminer.setAuthor(3);
            }else{
                if(adminer.getuName().equals("")){
                    adminer.setAuthor(4);
                }else{
                    adminer.setAuthor(5);
                }
            }
        }
        if(adminerMapper.userexit(adminer)==null) {
            adminerMapper.insert(adminer);
            return true;
        }else
            return false;
    }

   /* public List<Adminer> userlist(Local local,int index) {
        List<String> list=new ArrayList<String>();
        list=localMapper.comunityidlist(local);
        list.add("");
        return adminerMapper.selectById(list);
    }*/
    public PageBean<Adminer> userlist(Local local,int index){
        List<String> list=new ArrayList<String>();
        list=localMapper.comunityidlist(local);
        list.add("");
        PageHelper.startPage(index,8);
        List<Adminer> allItems = adminerMapper.selectById(list);
        PageBean<Adminer> pageData = new PageBean<>(index, 8, adminerMapper.countById(list));
        pageData.setItems(allItems);
        return pageData;
    }

    public boolean updatauser(Adminer adminer) {
        if(adminer.getcId().equals("")){
            adminer.setAuthor(2);
        }else{
            if(adminer.getbName().equals("")){
                adminer.setAuthor(3);
            }else{
                if(adminer.getuName().equals("")){
                    adminer.setAuthor(4);
                }else{
                    adminer.setAuthor(5);
                }
            }
        }
        if(adminerMapper.userexit(adminer)!=null) {
            adminerMapper.updateByName(adminer);
            return true;
        }else
            return false;
    }

    public boolean deleteuser(String name) {
        Adminer adminer=new Adminer();
        adminer.setName(name);
        if(adminerMapper.userexit(adminer)!=null) {
            adminerMapper.deleteByName(name);
            return true;
        }else
            return false;
    }

    public Adminer getuser(String name) {
        return adminerMapper.selectByName(name);
    }


  /*  @RabbitListener(queues = "queue1")
    public void processMessage1(Adminer adminer) {
        System.out.println( " 接收到来自queue1队列的消息：" + adminer.getAuthAdd());
        ListOperations<String,Adminer> listOperations = redisTemplate.opsForList();//进入redis服务器
        listOperations.rightPush("2",adminer);
    }*/
    //获取申请列表(带分页)
    public PageBean<Adminer> applicationlist(int index){
        ListOperations<String,Adminer> listOperations = redisTemplate.opsForList();
        PageHelper.startPage(index, 10);
        List<Adminer> allItems = new ArrayList<Adminer>();
        for(int i=0;i<listOperations.size("2");i++){
            allItems.add(listOperations.index("2",i));
        }
        PageBean<Adminer> pageData = new PageBean<>(index, 10, listOperations.size("2").intValue());
        pageData.setItems(allItems);
        return pageData;
    }

    public boolean application_delete(String name) {

        ListOperations<String,Adminer> listOperations = redisTemplate
                .opsForList();
        for(int i=0;i<listOperations.size("2");i++){
            if(listOperations.index("2",i).getName().equals(name)){
                System.out.println("delete");
                Adminer adminer=new Adminer();
                adminer=listOperations.index("2",i);
                listOperations.remove("2",0,adminer);
            }
        }
        return true;
        //System.out.println("要输出了"+listOperations.index("2",0).getName());
    }
}
