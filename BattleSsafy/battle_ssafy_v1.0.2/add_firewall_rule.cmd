netsh advfirewall firewall add rule name="battle_ssafy_net" dir=in action=allow edge=yes protocol=any program="%~dp0Battle_SSAFY.exe" 
netsh advfirewall firewall add rule name="battle_ssafy_tcp" dir=in action=allow edge=yes protocol=tcp localport=8747-8750
pause