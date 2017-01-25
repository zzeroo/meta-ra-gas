# Bringt warscheinlich nichts
# http://stackoverflow.com/questions/36897000/yocto-cross-compiling-creating-symbolic-link-for-ld-linux-armhf-so-3

do_install_append_tune-cortexa7hf () {
        ln -s /lib/ld-linux-armhf.so.3 ${D}/lib/ld-linux.so.3
}
