import PropTypes from 'prop-types';
import React from 'react'
import { useState } from 'react';

function Checkbox({ handler, value, defaultChecked, disabled, error }) {

  const [checked,setChecked] = useState(defaultChecked);

  const onClick = event => {

    event.preventDefault()

    const newChecked = !checked;

    setChecked(newChecked);

    if (handler) {
        handler(newChecked? value : undefined)
    }

  }

  if (disabled || error) {
    return (
      <span
        className={`checkbox disabled ${checked ? 'checked' : ''} ${
          error ? 'err' : ''
        }`}
      >
        <span className='caret' tabIndex='-1' />
      </span>
    )
  }
  return (
    <a
      href='/'
      className={`checkbox ${checked ? 'checked' : ''}`}
      onClick={onClick}
    >
      <span className='caret' tabIndex='-1' />
    </a>
  )
}

Checkbox.defaultProps = {
  disabled: false,
  error: false,
  handler: null,
  defaultChecked: false
}


Checkbox.propTypes = {
  disabled: PropTypes.bool,
  defaultChecked: PropTypes.bool,
  value: PropTypes.string.isRequired,
  error: PropTypes.bool,
  handler: PropTypes.func,
}

export default Checkbox
