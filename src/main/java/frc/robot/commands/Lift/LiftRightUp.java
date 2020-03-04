/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Lift;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lift;

public class LiftRightUp extends CommandBase {
  
  private final Lift m_lift;

  public LiftRightUp(Lift subsystem) {
  m_lift = subsystem;
  addRequirements(m_lift);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(Lift.m_rightLift.getSelectedSensorPosition() < 160000) {
      m_lift.RightLiftUp();
    } else {
      m_lift.StopLift();
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Lift.m_rightLift.getSelectedSensorPosition() < 160000) {
      return false;
    } else {
      return true;
    }
  }
}
