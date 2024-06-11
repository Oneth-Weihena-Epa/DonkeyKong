import greenfoot.*;
public class Mario extends Actor
{
    int speed;
    String Marioimage = "Mario-Idle-Right.png";
    GreenfootImage MarioLeft = new GreenfootImage ("Mario-Idle-Right.png"); 
    long lastTime;
    int Lives = 3;
    String LastPressed = "right";
    boolean HaveHammer = false;
    int timer = 100;
    long hammertimer;
    long hitTimer;
    int Shifter = 0;
    public void act() 
    {
        speed = speed + 1;
        setLocation( getX(), getY() + speed + Shifter);
        getWorld().showText("Lives : "+ Lives +"",1450, 50);
        if(isTouching(Hammer.class)){
            hammertimer= System.currentTimeMillis();
           HaveHammer = true;
        }
        if(isTouching(Barrel.class) && Lives > 0)
        {
            removeTouching(Barrel.class);
            hitTimer = System.currentTimeMillis();
            if(HaveHammer == false){
                Lives = Lives - 1;
            }
        }
        else if(isTouching(Barrel.class) && Lives <= 0){
            removeTouching(Barrel.class);
        }
        if(Lives <= 0)
        {
            MarioDied();
            if(System.currentTimeMillis() - hitTimer < 1000){
                    animationState = (animationState+1)%4;
            }
            else{
                setImage("mariodead5.png");
                getWorld().showText("GAME OVER", 750, 600);
                Greenfoot.stop();
             }
        }
        else if(Lives > 0)
        {
            if(HaveHammer){
                if(System.currentTimeMillis() - hammertimer > 5000){
                    HaveHammer = false;
               }
            }
        }
        if(speed > 0)
        {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() - 1);
                if(Greenfoot.isKeyDown("up") && Lives > 0)
                {
                    speed = - 30;
                    if(LastPressed.equals("left")){
                        setImage("marioJumpL.png");
                    }
                    else if(LastPressed.equals("right")){
                        setImage("marioJumpR.png");
                    }
                }
            }
        }
        if(speed <= 0)
        {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() + 1);
            }
        } 
        int lasttTime = 0;
        boolean startMovment = false;
        if (Greenfoot.isKeyDown("right") && Lives > 0) {
               LastPressed = "right";
               move(5);
               if(System.currentTimeMillis() - lastTime > timer){
                    animationState = (animationState+1)%5;
                    lastTime = System.currentTimeMillis();
               }
                while(isTouching(Floor.class))
                {
                  move(-1);
               }
               MarioMovmentRight();
         }
         
        else if(Greenfoot.isKeyDown("left") && Lives > 0) {
                LastPressed = "left";
                move(-5); 
                if(System.currentTimeMillis() - lastTime > timer){
                    animationState = (animationState+1)%5;
                    lastTime = System.currentTimeMillis();
               }
            while(isTouching(Floor.class))
            {
               move(1);
            }  
            MarioMovmentleft();
        } else { 
                if(Lives > 0){
                    if(!HaveHammer){
                        if(LastPressed.equals("left")){
                            setImage("Mario-Idle-Left.png");
                        }
                        else if(LastPressed.equals("right")){
                            setImage("Mario-Idle-Right.png");
                        }
                    }
                    else{
                        if(LastPressed.equals("left")){
                            setImage("marioHamUpL2.png");
                        }
                        else if(LastPressed.equals("right")){
                            setImage("marioHamUpR2.png");
                        }
                    }
                }
        }
        
        if(Greenfoot.isKeyDown("down") && Lives > 0)
        {
            speed = 50;
        }
    }
    int animationState = 0;
    public void MarioMovmentRight(){
        if(!HaveHammer){
            timer = 100;
            if(animationState == 0){
                setImage("marioR1.png");
            }
            if(animationState == 1){
                setImage("marioR2.png");
            }
            if(animationState == 2){
                setImage("marioR3.png");
            }
            if(animationState == 3){
                setImage("marioR2.png");
            }
             if(animationState == 4){
                setImage("marioR1.png");
            }
        }
        else{
            timer = 100;
            if(animationState == 0){
                Shifter = 0;
                setImage("marioHamUpR1.png");
            }
            if(animationState == 1){
                Shifter = 5;
                setImage("marioHamDR1.png");
            }
            if(animationState == 2){
                Shifter = 0;
                setImage("marioHamUpR2.png");
            }
            if(animationState == 3){
                Shifter = 5;
                setImage("marioHamDR2.png");
            }
        }
    }
    public void MarioMovmentleft(){
        if(!HaveHammer){
            timer = 100;
            if(animationState == 0){
                setImage("marioL1.png");
            }
            if(animationState == 1){
                setImage("marioL2.png");
            }
            if(animationState == 2){
                setImage("marioL3.png");
            }
            if(animationState == 3){
                setImage("marioL2.png");
            }
             if(animationState == 4){
                setImage("marioL1.png");
            }
        }
        else{
            timer = 100;
            if(animationState == 0){
                setImage("marioHamUpL1.png");
            }
            if(animationState == 1){
                setImage("marioHamDL1.png");
            }
            if(animationState == 2 ){
                setImage("marioHamUpL2.png");
            }
            if(animationState == 3){
                setImage("marioHamDL2.png");
            }
        }
    }
    public void MarioDied(){
        if(animationState == 0){
            setImage("mariodead1.png");
        }
        if(animationState == 1){
            setImage("mariodead2.png");
        }
        if(animationState == 2){
            setImage("mariodead3.png");
        }
        if(animationState == 3){
            setImage("mariodead4.png");
        }
    }
}
