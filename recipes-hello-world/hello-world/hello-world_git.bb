# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://git@github.com/zzeroo/hello-world.git;protocol=ssh"

SRCREV = "e6896f81bbe19439a0d8813186e0ecfadd6d2c25"
PR = "r4"
PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"


do_configure () {
	# A singel colon stands for true. So this task does nothing, but is valid.
	:
}

do_compile () {
	${CC} -o "${B}/hello" "${S}/hello.c"
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 hello ${D}${bindir}
}
