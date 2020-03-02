/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.BallMove;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.BallMover;

public class automatedBallMove extends CommandBase {
  
  private final BallMover m_BallMover;
  public automatedBallMove(BallMover subsystem) {
    m_BallMover = subsystem;
    addRequirements(m_BallMover);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(BallMover._pickProxy.get() == false && BallMover._midMove.get() == true && BallMover._endShoot.get() == false) {
      m_BallMover.move1();
    } else if(BallMover._pickProxy.get() == true && BallMover._midMove.get() == true && BallMover._endShoot.get() == false) {
      m_BallMover.move2();
    } else if(BallMover._pickProxy.get() == false && BallMover._midMove.get() == false && BallMover._endShoot.get() == false) {
      m_BallMover.move3();
    } else if(BallMover._pickProxy.get() == false && BallMover._midMove.get() == false && BallMover._endShoot.get() == true) {
      m_BallMover.move3();
    } else if(BallMover._pickProxy.get() == true && BallMover._midMove.get() == true && BallMover._endShoot.get() == true && RobotContainer.m_driver.getRawButton(6) == true) {
      m_BallMover.move2();
    } else {
      m_BallMover.StopMove();
    }


    if(BallMover._pickProxy.get() == false && BallMover._midMove.get() == true){
      m_BallMover.move1();
    } else if(BallMover._pickProxy.get() == true && BallMover._midMove.get() == false) {
      m_BallMover.StopMove();
    } else if(BallMover._pickProxy.get() == false && BallMover._midMove.get() == false) {
      m_BallMover.move2();
    } else if()

  }



  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
