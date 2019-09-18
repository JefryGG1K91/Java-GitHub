WinWaitActive("","Authentication Required","10")
WinFlash("", "Authentication Required",4,500)
$username = $CmdLIne[1]
$password=$CmdLine[2]
If WinExists("","Authentication Required") Then
  Send($username)
  Send("{TAB}")
  Send($password)
  Sleep(3000)
  Send("{Enter}")
ElseIf WinExists("","Chrome Legacy Window") Then
  Send($username)
  Send("{TAB}")
  Send($password)
  Sleep(3000)
  Send("{Enter}")
ElseIf WinExists("","Windows Security") Then
  Send($username)
  Send("{TAB}")
  Send($password)
  Sleep(3000)
  Send("{Enter}")
EndIf