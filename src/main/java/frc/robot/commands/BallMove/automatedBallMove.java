package frc.robot.commands.BallMove;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallMover;

public class automatedBallMove extends CommandBase {
  // The subsystem the command runs on
  public enum IndexerStage {
    EMPTY, BALL_PRESENT, BALL_INDEXED,BALL_PAST_INDEX, BALL_AT_SHOOT, FULL
  }

  private final BallMover m_BallMover;
  public boolean m_autoLoad = false;
  public boolean m_autoShoot = false;
  public boolean m_complete = false;
  public IndexerStage m_loadingStage = IndexerStage.EMPTY;
  public DigitalInput m_sensorShoot;
  public DigitalInput m_sensorBallReady;
  public DigitalInput m_sensorBallIndexed;

  public automatedBallMove(BallMover subsystem, boolean autoLoad, boolean autoShoot) {
    m_BallMover = subsystem;
    m_autoLoad = autoLoad;
    m_autoShoot = autoShoot;
    m_sensorShoot = BallMover._endShoot;
    m_sensorBallReady = BallMover._pickProxy;
    m_sensorBallIndexed = BallMover._midProxy;

    if(m_autoShoot){ // if requested to shoot it is higher priority
        m_autoLoad = false;
    }
    addRequirements(m_BallMover);
  }

  @Override
  public void initialize() {
    if(!m_sensorBallIndexed.get() && m_sensorBallReady.get()){ // handle specil case where they could start the auto index only with one ball at the Indexed state.
        // no we see the ball has indexed but no ball is staged
        m_loadingStage = IndexerStage.BALL_INDEXED;
        //send to the next stage and wait for ball present
        m_BallMover.StopMove();
    }else{
        m_loadingStage = IndexerStage.EMPTY;
    }
    m_complete = false;
  }

  @Override
  public void execute() {
      // here is where we want to auto index the balls if we have one present or stagged

      if(m_autoLoad){ // if m_autoLoad keep loading until full
        if(m_sensorShoot.get() == true){
            m_loadingStage = IndexerStage.BALL_AT_SHOOT;
            m_BallMover.StopMove();
        }

        SmartDashboard.putBoolean("Ball Ready", m_sensorBallReady.get());
        SmartDashboard.putBoolean("Ball Indexed", m_sensorBallIndexed.get());
        SmartDashboard.putBoolean("Shoot", m_sensorShoot.get());

        // SmartDashboard.putNumber("State",m_loadingStage);
        switch(m_loadingStage){
            case EMPTY:  // if we are EMPTY and auto load then run the indexer until ball ready sensor
                if(m_sensorBallReady.get() == false){
                    // now we see a ball is ready changed states
                    m_loadingStage = IndexerStage.BALL_PRESENT;
                }
                m_BallMover.move2();
                SmartDashboard.putNumber("State",0);
                break;
            case BALL_PRESENT:
                if(!m_sensorBallIndexed.get() && m_sensorBallReady.get() == true){
                    // no we see the ball has indexed but no ball is staged
                    m_loadingStage = IndexerStage.BALL_INDEXED;
                    //send to the next stage and wait for ball present
                    m_BallMover.StopMove();
                }else{
                    m_BallMover.move3();
                }
                SmartDashboard.putNumber("State",1);
                break;
            case BALL_INDEXED:
                if(m_sensorBallReady.get() == false){
                    // if we see that ball is at ready stage then set the stage back to Ball Present
                    m_loadingStage = IndexerStage.BALL_PAST_INDEX;
                }
                SmartDashboard.putNumber("State",2);
                break;
            case BALL_PAST_INDEX:
                if(!m_sensorBallIndexed.get()){
                  m_BallMover.move3();
                }else{
                  m_loadingStage = IndexerStage.BALL_PRESENT;
                  m_BallMover.StopMove();
                }
                break;
            case BALL_AT_SHOOT:
                m_BallMover.StopMove();
                m_complete = true;
                SmartDashboard.putNumber("State",3);
                break;
            case FULL:
                SmartDashboard.putNumber("State",4);
                m_BallMover.StopMove();
            break;
            
        }
      }else if(m_autoShoot){// auto shoot is a little bit different as we want to keep indexing until no balls are through the system

      }
  }

  @Override
  public boolean isFinished() {
      if(m_complete){
          return true;
      }else{
          return false;
      }
  }
}