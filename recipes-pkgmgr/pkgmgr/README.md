# Simple opkg Packet Manager Integration

```
cd /mnt/src/poky/build/tmp/deploy/ipk
python -m SimpleHTTPServer
```

```
# /etc/opkg/base-feeds.conf
src/gz all http://192.168.89.210:8000/all
src/gz bananapro http://192.168.89.210:8000/bananapro
src/gz cortexa7hf-neon-vfpv4 http://192.168.89.210:8000/cortexa7hf-neon-vfpv4
```

```
# opkg update
# opkg list |grep foo
# opkg install foo
```

# TODO

* `/etc/opkg/base-feeds.conf` sollte dynamisch angelegt werden (Hostname Konfig Var)


# Links

* [Intel white-paper](http://www.intel.com/content/dam/www/public/us/en/documents/white-papers/package-manager-white-paper.pdf)
