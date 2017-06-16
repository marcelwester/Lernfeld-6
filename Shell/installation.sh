 #!/bin/sh


VALUE=""
if [netstat -tulpn | 127.0.0.1:8888] != null]; then
	curl http://127.0.0.1:8888/kirag/kirag.repo > /etc/yum.repos.d/kirag.repo
	echo 'Repositorie eingetragen'
	# Alias für YUM (nur lokale Repos verwenden)
	echo >> /root/.bashrc
	echo "alias YUM='yum --disablerepo=\"*\" --enablerepo=\"*local*\"'" >> /root/.bashrc
	. /root/.bashrc
	echo 'Alia für yum erstellt'
	elif 
	echo 'Fehler!'
fi

	