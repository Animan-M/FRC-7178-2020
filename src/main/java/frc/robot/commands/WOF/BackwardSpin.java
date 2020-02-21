/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.WOF;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WheelOfFortune;

public class BackwardSpin extends CommandBase {
  
  private static WheelOfFortune m_WOF;

  public BackwardSpin(WheelOfFortune subsystem) {
    m_WOF = subsystem;
     addRequirements(m_WOF);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_WOF.backwardSpin();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
