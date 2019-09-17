WinWaitActive("","Authentication Required","10")
WinFlash("", "Authentication Required",4,500)
If WinExists("","Authentication Required") Then
  Send("jefry{TAB}")
  Send("12345{Enter}")
ElseIf WinExists("","Chrome Legacy Window")Then
  Send("jefry{TAB}")
  Send("12345{Enter}")
ElseIf WinExists("","Windows Security") Then
  Send("jefry{TAB}")
  Send("12345{Enter}")
EndIf