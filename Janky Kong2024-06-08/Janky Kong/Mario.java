import greenfoot.*;
public class Mario extends Actor
{
    int speed;
    String Marioimage = "Mario-Idle-Right.png";
    GreenfootImage MarioLeft = new GreenfootImage ("Mario-Idle-Right.png"); 
    long lastTime;
    int Lives = 7;
    String LastPressed = "right";
    boolean HaveHammer = false;
    public void act() 
    {
        speed = speed + 1;
        setLocation( getX(), getY() + speed);
        getWorld().showText("Lives : "+ Lives +"",1450, 50);
        if(isTouching(Hammer.class)){
           HaveHammer = true;
        }
        if(isTouching(Barrel.class))
        {
            removeTouching(Barrel.class);
            Lives = Lives - 1;
        }
        if(Lives == 0)
        {
            getWorld().showText("GAME OVER", 750, 600);
            Greenfoot.stop();
        }
        if(speed > 0)
        {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() - 1);
                if(Greenfoot.isKeyDown("up"))
                {
                    speed = - 27;
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
        if (Greenfoot.isKeyDown("right")) {
               LastPressed = "right";
               move(5);
               if(System.currentTimeMillis() - lastTime > 100){
                    animationState = (animationState+1)%4;
                    lastTime = System.currentTimeMillis();
               }
                while(isTouching(Floor.class))
                {
                  move(-1);
               }
               MarioMovmentRight();
         }
         
        else if(Greenfoot.isKeyDown("left")) {
                LastPressed = "left";
                move(-5); 
                if(System.currentTimeMillis() - lastTime > 100){
                    animationState = (animationState+1)%4;
                    lastTime = System.currentTimeMillis();
               }
            while(isTouching(Floor.class))
            {
               move(1);
            }  
            MarioMovmentleft();
        } else { 
            if(LastPressed.equals("left")){
                setImage("Mario-Idle-Left.png");
            }
            else if(LastPressed.equals("right")){
                setImage("Mario-Idle-Right.png");
            }
            startMovment = true;
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            speed = 50;
        }
    }
    int animationState = 0;
    public void MarioMovmentRight(){
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
                setImage("marioR4.png");
            }
    }
    public void MarioMovmentleft(){
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
                setImage("marioL4.png");
            }
    }
}
