program { char c scientific s int i
  if(i >= 5) then {
    s = 1.2e5
  }

  if(i > 5) then {
    s = 1.2e5
  } else {
    c = `a`
  }

  unless(i < 5) then {
    c = `a`
  }

  switch(i) {
    case 1: i =5
    case `z`: i = 42
    default: i = i + 5
  }

}