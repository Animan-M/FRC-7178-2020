/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class LiftArmUp extends CommandBase {

  private final Arm m_Arm;

  public LiftArmUp(Arm subsystem) {
    m_Arm = subsystem;
    addRequirements(m_Arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(Arm._top.get() == false || Arm.m_armMove.getSelectedSensorPosition() > 13500) {
      m_Arm.LiftArmUp();
    } else {
      m_Arm.ArmStop();
    }

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Arm._top.get() == false || Arm.m_armMove.getSelectedSensorPosition() > 13500) {
      return false;
    } else {
      return true;
    }
  }
}
