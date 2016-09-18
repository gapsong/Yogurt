nano /etc/network/interfaces
passwd
apt-get install nano wget
nano /etc/network/interfaces
apt-get install landscape-common
nano /etc/ssh/sshd_config 
service ssh restart
apt-get update
apt-get upgrade
mount /dev/cdrom /mnt
cp /mnt/VMwareTools-8.6.10-913593.tar.gz /tmp
cd /tmp/
tar -zxf VMwareTools-8.6.10-913593.tar.gz 
rm VMwareTools-8.6.10-913593.tar.gz 
cd vmware-tools-distrib/
./vmware-install.pl -d
reboot
umount /mnt
history 
apt-get update && apt-get upgrade -y
cat /dev/zero > zero.dat ; sync ; sleep 1 ; sync ; rm -Rf zero.dat
shutdonw now -h
shutdown now -h
df -h
apt-get update && apt-get update -y
apt-get update && apt-get upgrade -y
dpkg-reconfigure tzdata
apt-get clean
apt-get autoclean
apt-get clean all
df -h
apt-get -s clean
df -h
apt-get autoclean
cat /dev/zero > zero.dat ; sync ; sleep 1 ; sync ; rm -Rf zero.dat
df -h
apt-get autoclean
apt-get clean
df -h
shutdown now -h
nano /etc/network/interfaces
y
shutdown now -h
nano /etc/network/interfaces
shutdown now -h
nano /etc/network/interfaces
reboot
apt-get autoclean
apt-get update && apt-get upgrade -y
apt-get install vim -y
apt-get install landscape-common -y
nptoc
nproc
apt-get autoremove
vi /etc/hostname 
vi /etc/hosts
df -h
shutdown now -h
vmware-uninstall-tools.pl 
reboot
apt-get install open-vm-tools -y
uname -a
shutdown now -h
cat /dev/zero > zero.dat ; sync ; sleep 1 ; sync ; rm -Rf zero.dat; shutdown now -h
sudo apt-get update
shutdown now -h
apt-get install netcat
nc -l 5000
nc -l 5672
nc -l 80
nc -l 3000
nc -l 80
apt-get install docker.io
docker -version
docker -v
apt-cache search docker
apt-cache search compose
docker-compose
uname -r
sudo apt-get update
sudo apt-get install apt-transport-https ca-certificates
apt-key adv --keyserver hkp://p80.pool.sks-keyservers.net:80 --recv-keys 58118E89F3A912897C070ADBF76221572C52609D
cat /etc/apt/sources.list.d/docker.list
echo deb https://apt.dockerproject.org/repo ubuntu-trusty main > /etc/apt/sources.list.d/docker.list
cat /etc/apt/sources.list.d/docker.list
sudo apt-get update
sudo apt-get purge lxc-docker
apt-cache policy docker-engine
sudo apt-get purge docker.io
sudo apt-get install linux-image-extra-$(uname -r) linux-image-extra-virtual
ufw status
reboot
sudo groupadd docker
sudo usermod -aG docker $USER
sudo apt-get install docker-engine
sudo systemctl enable docker
sysctl enable docker
sudo service docker start
docker -v
docker-compose
apt-cache search docker-compose
curl -L https://github.com/docker/compose/releases/download/1.8.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
apt-get install curl
curl -L https://github.com/docker/compose/releases/download/1.8.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose
docker-compose -v
git
ls
git clone https://github.com/astoklas/HackZurich16.git
ls
git clon https://github.com/astoklas/HackZurich16-Listener.git
git clone https://github.com/astoklas/HackZurich16-Listener.git
ls
cd HackZurich16-Listener/
ls
cd ..
ls
cd HackZurich16
ls
docker-compose build
docker-compose up
docker-compose down
git
git pull
docker-compose build
nc -l 9443
nc -l 5222
nc -l 9443
nc -l 33434
nc -l 80-15000
nc -l
ls
cd HackZurich16-
cd HackZurich16-Listener/
ls
docker-compose build
docker-compose up
docker-compose down
nano docker-compose.yml 
docker-compose up
docker-compose down
docker-compose 
git pull
git stash
git pull
ls
cat docker-compose.yml 
ipconfig
ifconfig
git pull
cat docker-compose.yml 
docker ps
nano /etc/ssh/sshd_config 
service
service sshd restart
service openssh-server
service openssh
service opensshd
service ssh restart
exit
docker ps
netstat -a
netstat -aL
netstat -al
docker ps
netstat -aL | grep "LISTEN"
netstat -al | grep "LISTEN"
docker ps
cat /proc/sys/net/ipv4/ip_forward
iptables -L -n
sudo iptables -t nat -L -n
pwd
ls
cd HackZurich16
ls
cat docker-compose.yml 
docker-compose run --service-ports rabbitmq vendingmachineapi
docker-compose run --service-ports rabbitmq 
docker-compose docker-compose.yml 
netstat -akl
netstat -al
ifconfig
netstat -al
cd ..
cd HackZurich16-Listener/
docker-compose run --publish 8086:8086 influxdb
nano docker-compose.yml 
docker-compose run --publish 8086:8086 influxdb
ls
cd HackZurich16-Listener/
docker ps
nano docker-compose.yml 
ifconfig
ls
git pull
git stash
git pull
cat docker-compose.yml 
docker-compose build
docker-compose up
docker-sp
docker-ps
docker ps
netstat -al
docker-compose
docker-compose stop rabbitmq
docker-compose stop 
cd ..
cd HackZurich16
ls
docker-compose stop rabbitmq
docker-compose run --publish 5000:5000 vendingmachineapi
docker-compose run --publish 5000:5000 --publish 15001:5672 vendingmachineapi
docker ps
docker-compose run --publish 5000:5000 --publish 15001:5672 vendingmachineapi
docker-compose run  --publish 15001:5672 rabbitmq
docker ps
docker-compose run --publish 5000:5000 vendingmachineapi
docker ps
docker ps &
docker ps
docker-compose run --publish 5000:5000 vendingmachineapi
ls
cd HackZurich16
nano docker-compose.yml 
docker-compose up
docker-compose down
docker-compose 
docker-compose -P up
docker-compose --service-ports up
docker-compose up --service-ports 
docker-compose
docker-compose run -P
docker-compose run -p
docker-compose up
docker-compose down
docker-compose run --service-ports rabbitmq
docker-compose run --publish 5672:15001 rabbitmq
docker ps
cd ..
cd HackZurich16-Listener/
ls
docker-compose run --publish 3000:15002 demoListener
cat docker-compose.yml 
docker-compose run --publish 3000:15002 demolistener grafana
docker-compose run --publish 3000:15002 grafana
docker-compose run --publish 15002:15002 grafana
nano docker-compose.yml 
docker-compose run --publish 3000:15002 grafana
docker-compose run --publish 15002:3000 grafana
docker-compose run --publish 15002:3000 8086:8086 grafana
docker-compose run --publish 15002:3000 --publish 8086:8086 grafana
docker ps
docker-compose run --publish 15002:3000 --publish 8086:8086 grafana
docker-compose run --publish 15002:3000  grafana
docker ps
docker-compose run --publish 15001:5672 rabbitmq
cd HackZurich16
docker-compose run --publish 15001:5672 rabbitmq
docker-compose stop rabbitmq
docker-compose run --publish 15001:5672 rabbitmq
docker-compose stop vendingmachineapi
docker ps
docker exec -i -t 16b03b7bc302 /bin/bash
docker ps
docker-compose run demolistener
cd HackZurich16-Listener/
docker-compose run demolistener
exit
hostname ubuntu1
exit
passwd 
exit
docker ps
cd HackZurich16-Listener/
ls
docker-compose run demolistener
docker-compose run demolistener -e INFLUXDB_HOST=198.18.134.28
docker-compose run  -e INFLUXDB_HOST=198.18.134.28 demolistener
export
export INFLUXDB_PORT=8086
docker-compose run  -e INFLUXDB_HOST=198.18.134.28 demolistener
docker-compose run  -e INFLUXDB_PORT=8086 demolistener
git pull
docker ps
docker ps
ls
cd HackZurich16
ls
nano docker-compose.yml 
docker ps
docker-compose down
docker ps
docker-compose build
docker-compose up
nano docker-compose.yml 
docker-compose up
docker ps
nano docker-compose.yml 
docker-compose up
cd ..
cd HackZurich16-Listener/
git stash
git pull
docker-compose up
ls
cd influxdb/
ls
cd data/
ls
cd HackZurich16/
ls
cd awesome_policy/
ls
cd 5
ls
cd ..
cd 5
ls -al
cd ..
ls
cd ..
ls
cd ..
ls
cd ..
ls
cd wal
ls
cd HackZurich16/
ls
cd awesome_policy/
ls
cd 5
ls
ls -l
cat _00001.wal 
1;2c1;2c1;2c1;2c1;2c1;2c1;2c1;2c1;2c1;2c1;2c1;2c1;2c1;2c1;2c1;2c1;2c1;2c1;2c1;2c1;2c
cd.
cd ..
ls
cd ..
ls
clear
ls
cd ..
ls
rm -rf *
cd ..
ls
docker pull
git pull
docker-compose build
cd HackZurich16-Listener/
docker-compose down
netstat -al
cd ..
ls
cd HackZurich16
cat docker-compose.yml 
git commit
git commit -m "updating for dcloud env"
git push origin master
cat docker-compose.yml 
git pull
git stash
git pull
docker-compose down
docker-compose up
docker ps
ls
git pull
docker-compose build
docker ps
netstat -a
ls
docker -ps
docker ps
ls
cd HackZurich16
ls
docker exec -i -t 2e068586f58e
export
ls
docker exec -i -t 2e068586f58e /bin/bash
ls
nano docker-compose.yml 
ls
cd HackZurich16
ls
docker-compose up
docker-compose down
ls
cd docker-compose.yml 
cat docker-compose.yml 
docker-compose build
docker-compose up
docker-compose dow
docker-compose down
ifconfig
nano docker-compose.yml 
docker-compose up
docker ps
cd HackZurich16
ls
docker-compose down
ls
cd ..
cd HackZurich16-Listener/
LS
ls
docker-compose down
ls
cd influxdb/
ls
rm -rf *
ls
cd ..
ls
cd 
ls
cd .ssh/
ls
cat authorized_keys 
rm authorized_keys 
cd ..
passwd C1sco12345
passwd 
exit
cd HackZurich16
ls
nano docker-compose.yml 
docker ps
cd HackZurich16-Listener/
ls
cat docker-compose.yml 
docker-compose up
exit
docker ps
cd HackZurich16
ls
cat docker-compose.yml 
ls -al
node-red
cd HackZurich16
ls
cd ..
cd HackZurich16-Listener/
ls
cd demoListener/
ls
cd ..
ls
cd ~
node-red-start
node-red
mongo
ls
cd HackZurich16
ls
cd ..
ls
cd HackZurich16 && git stash && git pull && docker-compose build && cd ..\HackZurich16-Listener && git stash && git pull && docker-compose build
cd ..
ls
cd HackZurich16-Listener/
git stash && git pull && docker-compose build
cd ..
cd HackZurich16 && git stash && git pull && docker-compose build && cd ../HackZurich16-Listener && git stash && git pull && docker-compose build
cd ..
exit
cd HackZurich16
ls
cd vendingMachineAPI/
ls
cd ..
dockcd vendingMachineAPI/
ls
cd vendingMachineAPI/
ls
nano vendingMachineAPI.py 
cd ..
docker-compose build
docker-compose down
docker ps
docker exec -it 6885a59f4c6c
ls
docker -it exec 6885a59f4c6c
docker exec -it 6885a59f4c6c /bin/bash
docker-compose down
exit
ls
cd HackZurich16
ls
vendigMachine
history
ls
docker-compose
docker-compose run
docker-compose up
ls
cd vendingMachineAPI/
ls
nano vendingMachineAPI.py 
cd ..
docker-compose build
docker-compose up
cd HackZurich16
ls
docker ps
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
docker-compose down
nano vendingMachineAPI.py 
docker-compose build
docker-compose down
nano vendingMachineAPI.py 
nano Machine.py 
docker-compose build
docker-compose down
docker-compose build
nano vendingMachineAPI.py 
docker-compose build
docker-compose down
nano vendingMachineAPI.py 
docker-compose build
docker-compose down
cd HackZurich16
ls
vendingMachine
nano vendingMachine
nano vendingMachineAPI/
history
cd vendingMachineAPI.py
cd vendingMachineAPI/
nano vendingMachineAPI.py 
nano Machine.py 
docker-compose build
history
docke-compose down
docker-compose down
docker-compose up
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
nano vendingMachineAPI.py 
nano Machine.py 
nano vendingMachineAPI.py 
nano Machine.py 
docker-compose build
docker-compose down
nano vendingMachineAPI.py 
cd ..
docker -ps
docker ps
docker exec -it 28d8d6c5b029 /bin/bash 
ls
cd HackZurich16
ls
docker-compose up
ls
cd HackZurich16
ls
cd vendingMachine
ls
cd vendingMachine.py 
nano vendingMachine.py 
nano Machine.py 
docker-compose build
ls
docker-compuse build
docker-compose build
docker-compose down
nano vendingMachine.py 
docker-compose build
clear
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
nano vendingMachineAPI.py 
docker-compose build
docker-compose down
nano vendingMachineAPI.py 
docker-compose build
docker-compose down
nano vendingMachineAPI.py 
docker-compose build
docker-compose down
nano vendingMachineAPI.py 
docker-compose build
docker-compose down
nano vendingMachineAPI.py 
docker-compose build
docker-compose down
nano vendingMachineAPI.py 
ls
nano vendingMachineAPI.py 
docker-compose build
docker-compose down
cat docker-compose.yml
ls
cd
cd HackZurich16
cat docker-compose.yml
cd
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
nano vendingMachineAPI.py 
docker-compose build
docker-compose down
nano vendingMachineAPI.py 
docker-compose build
docker-compose down
nano vendingMachineAPI.py 
cat vendingMachineAPI.py 
cat Machine.py 
nano vendingMachineAPI.py 
docker-compose build
docker-compose down
nano vendingMachineAPI.py 
docker-compose build
docker-compose down
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
docker-compose up
cd HackZurich16
ls
cd vendingMachineAPI/
ls
docker-compose up
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
nano refillSMS.py 
vim vendingMachineAPI.py 
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
nano vendingMachineAPI.py 
nano Machine.py 
docker-compose build
docker-compose down
nano vendingMachineAPI.py 
nano refillSMS.py
python refillSMS.py 
nano vendingMachineAPI.py 
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
rm refillSMS.py
ls
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
nano vendingMachineAPI.py 
cd HackZurich16
ls
cd vendingMachineAPI/
ls
docker-compose up
cd HackZurich16
ls
cd vendingMachineAPI/
ls
nano vendingMachineAPI.py
nano Machine.py 
history
docker-compose build
docker-compose down
nano vendingMachineAPI.py
docker-compose up
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
docker-compose up
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
nano vendingMachineAPI.py.save
rm vendingMachineAPI.py.save
rm vendingMachineAPI.py.save.1
ls
nano vendingMachineAPI.py 
ls
nano Machine.py 
docker-compose build
ls
docker-compose down
ls
docker-compose up
python
ls
pip install requests
pip
python
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
nano requirements.txt 
nano Dockerfile
docker-compose build
docker-compose down
docker-compose up
easy_install requests
cd
ls
cd HackZurich16
ls
cd vendingMachine
ls
nano vendingMachine.py 
nano Machine.py 
cd ..
ls
cd ..
ls
sudo install requests
pip
sudo apt-get install pip
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
nano Machine.py 
docker-compose build
docker-compose down
docker-compose up
docker-compose down
pip install django-request
yum install python-setuptools
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
docker-compose up
cd ..
ls
python setup.py install
pip install requests
pythong
python
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
docker-compose up
pip3 install requests
docker-compose up
cd..
ls
cd ..
ls
cd ..
ls
easy_install-2.7 -U pip
pip-2.7 install requests
ls
cd /usr
ls
cd srx
cd src
ls
cd ..
cd local
ls
cd lib
ls
cd python3.4
ls
cd ..
rm python3.4/
rmdir python3.4/
rmdir -r python3.4/
ls
cd python2.7/
ls
cd site-packages/
ls
cd ..
ls dist-packages/
cd requ
cd requests
ls
cd ..
clear
cd..
cd ..
ls
cd ..
ls
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
nano vendingMachineAPI.py 
nano Machine.py 
docker-compose build
docker-compose down
sudo python get-pip.py
ls
docker-compose up
ls
nano Machine.py 
docker-compose build
docker-compose down
docker-compose up
ls
python
python3 --version
alias python=python3
python --version
sudo update-alternatives --config python
python3 --version
python --version
sudo pip install requests
sudo easy_install pip
sudo apt-get install python3-requests
ls
cd HackZurich16
ls
cd vendingMachineAPI/
ls
docker-compose builder
docker-compose build
docker-compose down
docker-compose up
python
python3 -c "import requests"
ls
dpkg -l
ls
nano Machine.py 
curl -O https://bootstrap.pypa.io/get-pip.py
python get-pip.py
sudo python get-pip.py
pip install requests
pip install requests --upgrade
ls
rm get-pip.py 
docker-compose build
docker-compose down
docker-compose up
ls
nano vendingMachineAPI.py 
nano Machine.py 
docker-compose build
docker-compose down
docker-compose up
id
type python
/usr/bin/python --version
sudo pip install requests
cd /usr/local/lib/python2.7/dist-packages/
ll
cd requests
ll
cd ..
ll
cd ~/HackZurich16/vendingMachineAPI
ll
type requirements.txt 
cat requirements.txt 
ps
ps -ef | grep vi
ll
pip
sudo pip uninstall requests
ll /usr/local/lib/python2.7/dist-packages/
id
pip install requests
ll /usr/local/lib/python2.7/dist-packages/
ls
ll
vi vendingMachineAPI.py 
