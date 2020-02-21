/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.WheelOfFortune;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.WheelOfFortune;

public class teleopWheelBack extends CommandBase {
  /**
   * Creates a new teleopWheelBack.
 * @param m_wheelOfFortune
   */
  public teleopWheelBack(WheelOfFortune m_wheelOfFortune) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_wheelOfFortune);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.controller1.getRawButton(5) == true) {
      WheelOfFortune.m_spinner.set(-30);
    } else {
      WheelOfFortune.m_spinner.set(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}