from django.core.exceptions import ValidationError


#supposed to check for spaces, so can't name anything just ' ' or
# any variation as to prevent unusable data (no clickable button per text names)
def validate_txt_feild(value):
    for char in value:
        if char != ' ':
            return
    raise ValidationError("Entry Contains all spaces")

if __name__ == '__main__':
    validate_txt_feild("valid entry")
    validate_txt_feild("  valid    entry   ")
    validate_txt_feild("       ")